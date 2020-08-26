package com.lti.training.usermicro.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lti.training.usermicro.dto.RegisterDto;
import com.lti.training.usermicro.dto.UserDetailDto;
import com.lti.training.usermicro.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class) // internally managed object
public class TestUserController {

	// while using the spring runner MockMvc will be exposed automatically 
	@Autowired
	private MockMvc mockMvc;
	
	// spring based mocking
	@MockBean
	private UserService service;
	
	// testing the functionality of the method associated with the REST Endpoint
	@Test
	public void testRegister() throws Exception {
		// testing object for parameter ( RegisterDto )
		RegisterDto registerDto = 
				new RegisterDto("First", "first@mail.com", "1234567", "1234567");
		
		// Expected response object
		UserDetailDto userDetailDto = 
				new UserDetailDto(1, "First", "first@mail.com");
		
		// mock/simulate the method of mock object
		when(this.service.register(registerDto)).thenReturn(userDetailDto);
		
		// build a request object for controller method (endpoint)
		
		RequestBuilder requestBuilder =  MockMvcRequestBuilders.post("/user/register")
					// need to convert Java  Object into JSON
					.content(asJsonString(registerDto))
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON);
		// generate the request
		
		/*this.mockMvc.perform(requestBuilder)
			.andExpect(status().isOk()) // assertion method
			.andExpect(content().json(asJsonString(userDetailDto)));
		*/
		MvcResult result =  this.mockMvc.perform(requestBuilder).andReturn();
		assertEquals(200, result.getResponse().getStatus());
		assertEquals(asJsonString(userDetailDto), result.getResponse().getContentAsString());
	}
	
	
	// convert object into JSON
	private static String asJsonString(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "";
		try {
			jsonString =  mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonString;
		
	}
	
}


























