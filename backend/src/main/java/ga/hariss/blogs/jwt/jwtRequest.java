package ga.hariss.blogs.jwt;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class jwtRequest {
	
	private String username;
	private String token;

}
