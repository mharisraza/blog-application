package ga.hariss.blogs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ga.hariss.blogs.jwt.JwtToken;
import ga.hariss.blogs.jwt.jwtRequest;
import ga.hariss.blogs.jwt.jwtResponse;

@RestController
@RequestMapping("/api/auth/")
public class AuthController {

	@Autowired
	private JwtToken jwtTokenHelper;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/login")
	public ResponseEntity<jwtResponse> createToken(@RequestBody jwtRequest jwtRequest) {

		this.authenticate(jwtRequest.getUsername(), jwtRequest.getToken());
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
		String token = this.jwtTokenHelper.generateToken(userDetails);
		jwtResponse jwtResponse = new jwtResponse();
		jwtResponse.setToken(token);
		return new ResponseEntity<jwtResponse>(jwtResponse, HttpStatus.OK);
	}

	private void authenticate(String username, String password) {
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,
				password);
		this.authenticationManager.authenticate(authenticationToken);
	}

}
