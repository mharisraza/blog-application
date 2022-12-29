package ga.hariss.blogs.services;

import ga.hariss.blogs.payloads.CommentDto;

public interface CommentService {
	
	CommentDto createComment(CommentDto commentDto, Integer postId);
	
	CommentDto updateComment(CommentDto commentDto, Integer commentId);
	
	void deleteComment(Integer commentId);

}
