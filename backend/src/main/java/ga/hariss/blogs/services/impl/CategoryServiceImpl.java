package ga.hariss.blogs.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ga.hariss.blogs.entities.Category;
import ga.hariss.blogs.exceptions.ResourceNotFound;
import ga.hariss.blogs.payloads.CategoryDto;
import ga.hariss.blogs.repositories.CategoryRepository;
import ga.hariss.blogs.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category category = this.mapper.map(categoryDto, Category.class);
		Category savedCategory = this.categoryRepo.save(category);
		return this.mapper.map(savedCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFound("Category", categoryId));
		category.setTitle(categoryDto.getTitle());
		return this.mapper.map(this.categoryRepo.save(category), CategoryDto.class);
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFound("Category", categoryId));
		return this.mapper.map(category, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getCategories() {
		List<Category> categories = this.categoryRepo.findAll();
		return categories.stream().map((category) -> this.mapper.map(category, CategoryDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFound("Category", categoryId));
		this.categoryRepo.delete(category);
	}

}
