package ga.hariss.blogs.helper;

public class Constant {
	
	public static final String CROSS_ORIGIN = "http://localhost:3000/";
	
	public static final String DEFAULT_BLOG_IMAGE = "default.png";
	public static final String PATH_TO_BLOG_IMAGES = "src/main/resources/static/blog_images";
	
	public static final String PATH_TO_USER_IMAGES = "src/main/resources/static/user_images";

	public static final String EMAIL_REGEX_PATTERN = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@(gmail|duck|outlook|yahoo)\\\\.com$";
	public static final String PASSWORD_REGEX_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\\\d)(?=.*[^\\\\da-zA-Z]).{8,}$";
	public static final String INVALID_EMAIL_MESSAGE = "Invalid or Disposable Email Address isn't allowed.";
	public static final String INVALID_PASSWORD_MESSAGE = "Contains atleast 8 char, 1 Special symbol, one lower case, one upper case.";
	
	public static final String IMAGE_JPEG_VALUE = "image/jpeg";

}