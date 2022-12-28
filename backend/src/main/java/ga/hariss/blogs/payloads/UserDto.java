package ga.hariss.blogs.payloads;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

	private Integer id;

	@NotBlank
	private String name;

	@Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@(gmail|duck|outlook|yahoo)\\.com$", message = "Invalid or Temporay Email Address isn't allowed.")
	@NotBlank
	private String email;

	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^\\da-zA-Z]).{8,}$", message = "Contains atleast 8 char, 1 Special symbol, one lower case, one upper case.")
	@NotBlank
	private String password;

}
