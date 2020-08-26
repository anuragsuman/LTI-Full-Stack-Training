package com.lti.training.postmicro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDataDto {
	private Integer id;
	private String title;
	private String tags;
	private String post;
}
