package ga.hariss.blogs.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtToken jwtTokenHelper;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		// getting token

		String requestToken = request.getHeader("Authorization");

		System.out.println("Token: " + requestToken);

		String username = null;
		String token = null;

		if (request != null && requestToken!=null && requestToken.startsWith("Bearer")) {

			token = requestToken.substring(7);

			try {

				username = this.jwtTokenHelper.getUsernameFromToken(token);

			} catch (IllegalArgumentException ex) {

				System.out.println("Unable to get jwt token");

			} catch (ExpiredJwtException ex) {
				System.out.println("Toke is expired");

			} catch (MalformedJwtException ex) {
				System.out.println("Malformed JWT Token");
			}

		} else {
			System.out.println("JWT TOKEN DOESN'T BEGIN WITH BEARER");
		}

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

			if (this.jwtTokenHelper.validateToken(token, userDetails)) {

				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

			}

			else {	
				System.out.println("INVALID TOKEN");
			}

		} else {
			System.out.println("username is null or context is not null");
		}

		filterChain.doFilter(request, response);

	}

}
