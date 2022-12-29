package ga.hariss.blogs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ga.hariss.blogs.helper.ApiResponse;
import ga.hariss.blogs.payloads.PostDto;
import ga.hariss.blogs.services.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {

	@Autowired
	private PostService postService;

	// creating new post
	@PostMapping("/add-post/user/{userId}/category/{categoryId}")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId,
			@PathVariable Integer categoryId) {
		PostDto savedPost = this.postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<PostDto>(savedPost, HttpStatus.OK);
	}
	
	// update existing post
	@PutMapping("/update-post/by-id/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Integer postId) {
		PostDto updatedPost = this.postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDto>(updatedPost, HttpStatus.OK);
	}
	
	//delete post by id
	@DeleteMapping("/delete-post/by-id/{postId}")
	public ResponseEntity<ApiResponse> deletePostById(@PathVariable Integer postId) {
		this.postService.deletePostById(postId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Post deleted successfully with id: "+postId, "success"), HttpStatus.OK);
	}
	
	

	// get post by id
	@GetMapping("/get-post/by-id/{postId}")
	public ResponseEntity<PostDto> getPost(@PathVariable Integer postId) {
		PostDto post = this.postService.getPost(postId);
		return new ResponseEntity<PostDto>(post, HttpStatus.FOUND);
	}

	// get all posts
	@GetMapping("/get-all-posts")
	public ResponseEntity<List<PostDto>> getPosts() {
		List<PostDto> posts = this.postService.getPosts();
		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
	}

	// get all posts by user
	@GetMapping("/get-all-posts/by-user/{userId}")
	public ResponseEntity<List<PostDto>> getAllPostsByUser(@PathVariable Integer userId) {
		List<PostDto> posts = this.postService.getPostsByUser(userId);
		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
	}

	// get all posts inside the category
	@GetMapping("/get-all-posts/by-category/{categoryId}")
	public ResponseEntity<List<PostDto>> getAllPostsByCategory(@PathVariable Integer categoryId) {
		List<PostDto> posts = this.postService.getPostsByCategory(categoryId);
		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
	}

}
