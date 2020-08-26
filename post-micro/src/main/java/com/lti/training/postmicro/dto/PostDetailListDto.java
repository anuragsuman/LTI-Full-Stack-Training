package com.lti.training.postmicro.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDetailListDto {

	private UserDetailDto userDetailDto;
	private List<PostDataDto> postDataList;
	
}
