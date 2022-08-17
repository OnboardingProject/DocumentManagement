package com.documentmanagement.controller;

import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.documentmanagement.service.AccountService;


import junit.framework.Assert;

import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;



@RunWith(MockitoJUnitRunner.class)
public class AccountControllerTest {
	 private MockMvc mockMvc;
	 private InputStream is;
	
		@InjectMocks
		private AccountController accountControllerObj;
		@Mock
		private AccountService serviceMock;
		
		  @Before
		    public void init() {
		        mockMvc = MockMvcBuilders.standaloneSetup(accountControllerObj).build();
		        is = accountControllerObj.getClass().getClassLoader().getResourceAsStream("excel.xlsx");
		    }
		@Test
		 public void testUploadFile() throws Exception {
	        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", "excel.xlsx", "multipart/form-data", is);
	        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.multipart("/upload").file(mockMultipartFile).contentType(MediaType.MULTIPART_FORM_DATA))
	                .andExpect(MockMvcResultMatchers.status().is(200)).andReturn();
	        Assert.assertEquals(200, result.getResponse().getStatus());
	        Assert.assertNotNull(result.getResponse().getContentAsString());
	        Assert.assertEquals("excel.xlsx", result.getResponse().getContentAsString());
}
}
