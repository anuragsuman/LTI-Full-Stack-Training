package com.lti.training.postmicro.service;

import com.lti.training.postmicro.dto.PostDetailDto;
import com.lti.training.postmicro.dto.PostDetailListDto;
import com.lti.training.postmicro.dto.PostDto;

public interface PostService {
	public PostDetailDto addPost(Integer userId, PostDto postDto);
	public PostDetailListDto getAllPost(Integer userId);
}
