package ga.hariss.blogs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ga.hariss.blogs.entities.User;
import ga.hariss.blogs.exceptions.ResourceNotFound;
import ga.hariss.blogs.repositories.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {


	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = this.userRepo.findByEmail(username)
				.orElseThrow(() -> new ResourceNotFound("User", "email: " + username));

		return new CustomUserDetails(user); 
	}
	

}
