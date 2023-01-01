package ga.hariss.blogs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ga.hariss.blogs.jwt.JwtToken;
import ga.hariss.blogs.jwt.jwtRequest;
import ga.hariss.blogs.jwt.jwtResponse;

@RestController
@RequestMapping("/api/auth/")
public class LoginController {

	@Autowired
	private JwtToken jwtTokenHelper;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@PostMapping("/login")
	public ResponseEntity<jwtResponse> createToken(@RequestBody jwtRequest request) {
	    jwtResponse response = new jwtResponse();

	    // Load user by username
	    UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUsername());
	    if (userDetails == null) {
	        response.setToken("Token cannot be generated: Invalid username.");
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }

	    // Check if password is correct
	    if (!checkPassword(request.getPassword(), userDetails.getPassword())) {
	        response.setToken("Token cannot be generated: Invalid password.");
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }

	    // Authenticate user
	    try {
	        this.authenticate(request.getUsername(), request.getPassword(), userDetails);
	    } catch (BadCredentialsException e) {
	        response.setToken("Token cannot be generated: Invalid credentials.");
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    } catch (AuthenticationException e) {
	        response.setToken("Token cannot be generated: Authentication error.");
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }

	    // Generate JWT for user
	    String token = this.jwtTokenHelper.generateToken(userDetails);
	    response.setToken(token);

	    return new ResponseEntity<>(response, HttpStatus.OK);
	}

	private void authenticate(String username, String password, UserDetails userDetails) throws AuthenticationException {
	    // Create an authentication token
	    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
	        username, password
	    );

	    // Authenticate user
	    this.authenticationManager.authenticate(authenticationToken);
	}
	
	public boolean checkPassword(String plainTextPassword, String hashedPassword) {
		return passwordEncoder.matches(plainTextPassword, hashedPassword);
	}

}
