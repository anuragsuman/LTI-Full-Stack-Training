package com.lti.training.postmicro.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.training.postmicro.dto.PostDetailDto;
import com.lti.training.postmicro.dto.PostDetailListDto;
import com.lti.training.postmicro.dto.PostDto;
import com.lti.training.postmicro.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {

	// dependency
	private PostService postService;
	
	public PostController(PostService postService) {
		// TODO Auto-generated constructor stub
		this.postService = postService;
	}
	
	// Add a new Post
	// EndPoint - /post/add/{userId} [POST]
	@PostMapping("/add/{userId}")
	public ResponseEntity<PostDetailDto> addPost(@PathVariable Integer userId, @RequestBody PostDto postDto) {
		// Service layer
		PostDetailDto postDetailDto =  this.postService.addPost(userId, postDto);
		ResponseEntity<PostDetailDto> response = 
				new ResponseEntity<PostDetailDto>(postDetailDto, HttpStatus.OK);
		
		return response;
	}
	
	// get post list 
	// EndPoint - /post/get/{userId} [GET]
	@GetMapping("/get/{userId}")
	public ResponseEntity<PostDetailListDto> getAllPost(@PathVariable Integer userId) {
		// Service layer
		PostDetailListDto postDetailListDto =  this.postService.getAllPost(userId);
		ResponseEntity<PostDetailListDto> response = 
				new ResponseEntity<PostDetailListDto>(postDetailListDto, HttpStatus.OK);
		
		return response;
	}
}
