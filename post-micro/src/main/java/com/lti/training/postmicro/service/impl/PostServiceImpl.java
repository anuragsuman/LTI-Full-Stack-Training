package com.lti.training.postmicro.service.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lti.training.postmicro.dto.PostDataDto;
import com.lti.training.postmicro.dto.PostDetailDto;
import com.lti.training.postmicro.dto.PostDetailListDto;
import com.lti.training.postmicro.dto.PostDto;
import com.lti.training.postmicro.dto.UserDetailDto;
import com.lti.training.postmicro.entity.Post;
import com.lti.training.postmicro.feignproxy.UserServiceProxy;
import com.lti.training.postmicro.repository.PostRepository;
import com.lti.training.postmicro.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	// private static final String USER_URL = "http://localhost:9090/user-micro/user";
	private static final String USER_URL = "http://user-micro/user-micro/user";
	
	/*
	@Value("${postmicro.user.url}")
	private String url;
	*/
	
	// dependency
	private PostRepository postRepository;
	// private RestTemplate restTemplate;
	private UserServiceProxy feignProxy;
	
	@Autowired
	private Environment environment;
	
	@Autowired
	public PostServiceImpl(PostRepository postRepository,
						 	UserServiceProxy feignProxy) {
							//RestTemplate restTemplate) {
		this.postRepository = postRepository;
		// this.restTemplate = restTemplate;
		this.feignProxy = feignProxy;
		
	}
	
	/*@Override
	public PostDetailDto addPost(Integer userId, PostDto postDto) {
		// Convert DTO into entity
		Post post = new Post(null, 
							 userId, 
							 postDto.getTitle(), 
							 postDto.getTags(), 
							 postDto.getPost());
		// persist into DB
		post = this.postRepository.save(post);
		
		// connect/call user-micro service
		// String url = environment.getProperties().get("postmicro.user.url").toString();
		UserDetailDto userDetailDto = 
				this.restTemplate.getForObject(USER_URL + "/get/" + userId, UserDetailDto.class);
		
		// create DTO
		PostDetailDto postDetailDto = 
				new PostDetailDto(post.getId(), 
								  post.getTitle(), 
								  post.getTags(), 
								  post.getPost(), 
								  userDetailDto);
		return postDetailDto;
	}

	@Override
	public PostDetailListDto getAllPost(Integer userId) {
		// get user data from user-micro
		UserDetailDto userDetailDto = 
				this.restTemplate.getForObject(USER_URL + "/get/" + userId, UserDetailDto.class);
		// get data from database
		List<Post> posts = this.postRepository.findByUserId(userId);
		// convert all Post object(entity) into PostDataDto(DTO)
		/*List<PostDataDto> postDataList = new ArrayList<PostDataDto>();
		for(Post post : posts) {
			PostDataDto postDataDto = 
					new PostDataDto(post.getId(), 
									post.getTitle(), 
									post.getTags(), 
									post.getPost());
			postDataList.add(postDataDto);
		}*/
		/*List<PostDataDto> postDataList = 
				posts.stream()
				.map(post->{
					PostDataDto postDataDto = 
							new PostDataDto(post.getId(), 
											post.getTitle(), 
											post.getTags(), 
											post.getPost());
					// return postDataDto;
				}).collect(Collectors.toList());
		List<PostDataDto> postDataList = 
				posts.stream()
				.map(post-> new PostDataDto(post.getId(), 
						post.getTitle(), 
						post.getTags(), 
						post.getPost()))
				.collect(Collectors.toList());
					
		
		// assemble
		PostDetailListDto postDetailListDto = 
				new PostDetailListDto(userDetailDto, postDataList);
		
		return postDetailListDto;
	}*/
	@Override
	public PostDetailDto addPost(Integer userId, PostDto postDto) {
		// Convert DTO into entity
		Post post = new Post(null, 
							 userId, 
							 postDto.getTitle(), 
							 postDto.getTags(), 
							 postDto.getPost());
		// persist into DB
		post = this.postRepository.save(post);
		
		// connect/call user-micro service
		// String url = environment.getProperties().get("postmicro.user.url").toString();
		UserDetailDto userDetailDto = 
				this.feignProxy.getUserDetail(userId).getBody();
		
		// create DTO
		PostDetailDto postDetailDto = 
				new PostDetailDto(post.getId(), 
								  post.getTitle(), 
								  post.getTags(), 
								  post.getPost(), 
								  userDetailDto);
		return postDetailDto;
	}

	@Override
	public PostDetailListDto getAllPost(Integer userId) {
		// get user data from user-micro
		UserDetailDto userDetailDto = 
				this.feignProxy.getUserDetail(userId).getBody();
		// get data from database
		List<Post> posts = this.postRepository.findByUserId(userId);
		// convert all Post object(entity) into PostDataDto(DTO)
		
		
		List<PostDataDto> postDataList = 
				posts.stream()
				.map(post-> new PostDataDto(post.getId(), 
						post.getTitle(), 
						post.getTags(), 
						post.getPost()))
				.collect(Collectors.toList());
					
		
		// assemble
		PostDetailListDto postDetailListDto = 
				new PostDetailListDto(userDetailDto, postDataList);
		
		return postDetailListDto;
	}

}
