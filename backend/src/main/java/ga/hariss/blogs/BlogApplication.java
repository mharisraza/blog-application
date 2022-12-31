package ga.hariss.blogs;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;

import ga.hariss.blogs.helper.Constant;


@SpringBootApplication
@ComponentScan(basePackages = "ga.hariss.blogs.*")
@CrossOrigin(origins = Constant.CROSS_ORIGIN)
@EnableJpaRepositories("ga.hariss.blogs.repositories")
public class BlogApplication {
	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	


}
