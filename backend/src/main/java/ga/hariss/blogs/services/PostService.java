package ga.hariss.blogs.services;

import java.util.List;

import ga.hariss.blogs.payloads.PostDto;

public interface PostService {
	
	
	// create
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	//update
	PostDto updatePost(PostDto postDto, Integer postId);
	
	//get single post
	PostDto getPost(Integer postId);
	
	// get all posts
	List<PostDto> getPosts();
	
	// delete post
	void deletePostById(Integer postId);
	
	//get all posts by categories
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	// get posts by user
	List<PostDto> getPostsByUser(Integer userId);

}
