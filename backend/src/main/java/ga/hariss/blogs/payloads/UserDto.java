package ga.hariss.blogs.payloads;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import ga.hariss.blogs.helper.Constant;
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

	@Pattern(regexp = Constant.EMAIL_REGEX_PATTERN, message = Constant.INVALID_EMAIL_MESSAGE)
	@NotBlank
	private String email;

	@Pattern(regexp = Constant.PASSWORD_REGEX_PATTERN, message = Constant.INVALID_PASSWORD_MESSAGE)
	@NotBlank
	private String password;
	
	private boolean isEnable;

}
