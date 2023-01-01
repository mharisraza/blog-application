package ga.hariss.blogs;

import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

import ga.hariss.blogs.entities.Role;
import ga.hariss.blogs.entities.User;
import ga.hariss.blogs.helper.Constant;
import ga.hariss.blogs.repositories.UserRepository;


@SpringBootApplication
@ComponentScan(basePackages = "ga.hariss.blogs.*")
@CrossOrigin(origins = Constant.CROSS_ORIGIN)
@EnableJpaRepositories("ga.hariss.blogs.repositories")
public class BlogApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepo;
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		
		User user = new User();
		
		Set<Role> roles = new HashSet<>();
		roles.add(new Role("ROLE_ADMIN"));
		
		user.setId(1);
		user.setEmail("harisraza@duck.com");
		user.setPassword(passwordEncoder.encode("heysup@999"));
		user.setEnable(true);
		user.setName("Haris");
		user.setRoles(roles);
		
		this.userRepo.save(user);
		
	}
	


}
