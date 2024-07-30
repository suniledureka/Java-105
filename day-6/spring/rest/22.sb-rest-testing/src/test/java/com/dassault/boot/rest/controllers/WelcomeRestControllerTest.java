package com.dassault.boot.rest.controllers;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.dassault.boot.rest.services.WelcomeService;

@WebMvcTest(value = WelcomeRestController.class)
class WelcomeRestControllerTest {
	@MockBean
	private WelcomeService service;
	
	@Autowired
	private MockMvc mockMvc; // used to send a request to REST API
	
	@Test
	void testShowWelcomeMessage() throws Exception{
		//define Mock object behaviour
		Mockito.when(service.generateWelcomeMessage()).thenReturn("welcome");
		
		//create an HTTP Request to access our rest controller method - prepare HTTP get request
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/welcome");
		
		//sending HTTP request
		ResultActions resultAction = mockMvc.perform(requestBuilder);
		
		//get the response
		MvcResult mvcResult = resultAction.andReturn();
		
		//validate the response
		MockHttpServletResponse response = mvcResult.getResponse();
		
		String responseText = response.getContentAsString();
		
		//assertNotNull(responseText);
		assertEquals("welcome", responseText);
		
		//int status = response.getStatus();
		//assertEquals(200, status);
	}

	@Test
	void testShowWelcomeMessage1() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/welcome"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
}
