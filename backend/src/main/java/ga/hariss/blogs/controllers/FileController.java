package ga.hariss.blogs.controllers;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.engine.jdbc.StreamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ga.hariss.blogs.helper.Constant;
import ga.hariss.blogs.payloads.PostDto;
import ga.hariss.blogs.services.FileService;
import ga.hariss.blogs.services.PostService;

@RestController
@RequestMapping("/api/images/")
public class FileController {

	@Autowired
	private FileService fileService;

	@Autowired
	private PostService postService;
	

	// upload or update image.
	@PostMapping("/upload/post/{postId}")
	public ResponseEntity<PostDto> uploadBlogImage(@PathVariable Integer postId,
			@RequestParam("image") MultipartFile image) throws IOException {

		PostDto postDto = this.postService.getPost(postId);

		String fileName = this.fileService.uploadImage(Constant.PATH_TO_BLOG_IMAGES, image);

		postDto.setImageName(fileName);
		PostDto updatedPost = this.postService.updatePost(postDto, postId);

		return new ResponseEntity<PostDto>(updatedPost, HttpStatus.OK);
	}
	
	
	// getting image (do not recommended to use this if your images are in static folder)
	@GetMapping(value = "/get-blog-image/{imageName}", produces = Constant.IMAGE_JPEG_VALUE)
	public void getImage(@PathVariable String imageName, HttpServletResponse httpResponse) throws IOException {
		
		InputStream image = this.fileService.getImage(Constant.PATH_TO_BLOG_IMAGES, imageName);
		httpResponse.setContentType(Constant.IMAGE_JPEG_VALUE);
		StreamUtils.copy(image, httpResponse.getOutputStream());
	}

}
