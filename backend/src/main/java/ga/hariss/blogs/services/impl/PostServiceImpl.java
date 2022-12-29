package ga.hariss.blogs.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ga.hariss.blogs.entities.Category;
import ga.hariss.blogs.entities.Post;
import ga.hariss.blogs.entities.User;
import ga.hariss.blogs.exceptions.ResourceNotFound;
import ga.hariss.blogs.payloads.PostDto;
import ga.hariss.blogs.repositories.CategoryRepository;
import ga.hariss.blogs.repositories.PostRepository;
import ga.hariss.blogs.repositories.UserRepository;
import ga.hariss.blogs.services.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepo;

	@Autowired
	private CategoryRepository categoryRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {

		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFound("User", userId));
		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFound("Category", categoryId));

		Post post = this.mapper.map(postDto, Post.class);
		post.setImageName("default.jpg");
		post.setDate(new Date());
		post.setUser(user);
		post.setCategory(category);

		return this.mapper.map(this.postRepo.save(post), PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		Post oldPost = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFound("Post", postId));
		
		oldPost.setCategory(this.mapper.map(postDto.getCategory(), Category.class));
		oldPost.setContent(postDto.getContent());
		oldPost.setDate(postDto.getDate());
		oldPost.setImageName(postDto.getImageName());
		oldPost.setTitle(postDto.getTitle());
		
		return this.mapper.map(this.postRepo.save(oldPost), PostDto.class);
	}

	@Override
	public PostDto getPost(Integer postId) {
		Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFound("Post", postId));
		return this.mapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getPosts() {
		List<Post> posts = this.postRepo.findAll();
		return posts.stream().map((post) -> this.mapper.map(post, PostDto.class)).collect(Collectors.toList());
	}

	@Override
	public void deletePostById(Integer postId) {
		Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFound("Post", postId));
		this.postRepo.delete(post);
	}

	@Override
	public List<PostDto> getPostsByCategory(Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFound("Category", categoryId));
		List<Post> posts = this.postRepo.findByCategory(category);
		return posts.stream().map((post) -> this.mapper.map(post, PostDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<PostDto> getPostsByUser(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFound("User", userId));
		List<Post> posts = this.postRepo.findByUser(user);
		return posts.stream().map((post) -> this.mapper.map(post, PostDto.class)).collect(Collectors.toList());
	}

}
