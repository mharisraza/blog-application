package ga.hariss.blogs.exceptions;

public class ResourceNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	String resourceName;
	Integer fieldValue;

	public ResourceNotFound(String resourceName, Integer fieldValue) {
		super(String.format("%s not found with ID: %s", resourceName, fieldValue));
		this.resourceName = resourceName;
		this.fieldValue = fieldValue;
	}

}
