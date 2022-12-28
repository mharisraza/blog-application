package ga.hariss.blogs.services;

import java.util.List;

import ga.hariss.blogs.payloads.CategoryDto;

public interface CategoryService {
	
	// create
	CategoryDto createCategory(CategoryDto categoryDto);
	
	//update
	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	
	// get single category.
	
	CategoryDto getCategory(Integer categoryId);
	
	// get all categories
	
	List<CategoryDto> getCategories();
	
	// delete category
	
	void deleteCategory(Integer categoryId);

}
