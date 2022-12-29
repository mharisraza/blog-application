package ga.hariss.blogs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ga.hariss.blogs.helper.ApiResponse;
import ga.hariss.blogs.payloads.CommentDto;
import ga.hariss.blogs.services.CommentService;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

	@Autowired
	private CommentService commentService;

	// adding comment
	@PostMapping("/add-comment/on-post/{postId}")
	public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto, @PathVariable Integer postId) {
		CommentDto createdComment = this.commentService.createComment(commentDto, postId);
		return new ResponseEntity<CommentDto>(createdComment, HttpStatus.CREATED);
	}

	// update comment
	@PutMapping("/update-comment/comment/{commentId}")
	public ResponseEntity<CommentDto> updateComment(@RequestBody CommentDto commentDto,
			@PathVariable Integer commentId) {
		CommentDto updatedComment = this.commentService.updateComment(commentDto, commentId);
		return new ResponseEntity<CommentDto>(updatedComment, HttpStatus.OK);
	}
	
	// delete comment
	@DeleteMapping("/delete-comment/comment/{commentId}")
	public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId) {
		this.commentService.deleteComment(commentId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Comment delete successfully with id: "+commentId, "success"), HttpStatus.OK);
	}
}
