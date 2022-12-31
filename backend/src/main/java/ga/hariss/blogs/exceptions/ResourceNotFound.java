package ga.hariss.blogs.exceptions;

public class ResourceNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	String resourceName;
	Integer fieldValue;
	String value;

	public ResourceNotFound(String resourceName, Integer fieldValue) {
		super(String.format("%s not found with ID: %s", resourceName, fieldValue));
		this.resourceName = resourceName;
		this.fieldValue = fieldValue;
	}

	public ResourceNotFound(String resourceName, String value) {
		super(String.format("%s not found with this %s", resourceName, value));
		this.resourceName = resourceName;
		this.value = value;
	}
	
	

}
