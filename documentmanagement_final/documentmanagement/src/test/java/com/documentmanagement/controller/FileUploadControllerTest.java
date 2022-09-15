package com.documentmanagement.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.documentmanagement.entity.Account;
import com.documentmanagement.request.DocumentRequest;
import com.documentmanagement.response.FileUploadResponse;
import com.documentmanagement.service.FileUploadService;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class FileUploadControllerTest {
	/*
	 * private MockMvc mockMvc; private InputStream is;
	 */
	@InjectMocks
	private FileUploadController accountControllerObj;
	@Mock
	private FileUploadService serviceMock;

	/**
	 * 
	 * @throws Exception
	 */
	/*@Test
	public void insertAccountTest() throws Exception {
		Account accounts = new Account();
		Mockito.when(serviceMock.insertAccount()).thenReturn(null);
		accountControllerObj.insertAccountDetails();
		
		 * Assert.assertEquals(accountControllerObj.insertAccountDetails(),
		 * Mockito.when(serviceMock.insertAccount()).thenReturn(null));
		 

	}*/

	@Test
	public void userInfoTest() {
		Mockito.when(serviceMock.getUserInfo()).thenReturn(null);
		accountControllerObj.userInfo();
	}

	@Test
	public void uploadFileTest() throws Exception {
		Mockito.when(serviceMock.uploadFile(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(null);
		ResponseEntity<?> res = accountControllerObj.uploadFile1(Mockito.any(), Mockito.any(), Mockito.any());
		Assert.assertTrue(res.getStatusCode().equals(HttpStatus.OK));
	}

	@Test(expected = Exception.class)
	public void uploadFileSuccessTest() throws Exception {
		FileUploadResponse response = new FileUploadResponse();
		
		byte[] data = new byte[] {1, 2, 3, 4};
		MultipartFile mpf = Mockito.mock(MultipartFile.class);
		
		response.setDocumentId("1");
		response.setDocumentSeq("agree");
		DocumentRequest doc = new DocumentRequest();
		doc.setDocumentId("1");
		doc.setDocumentSeq("agree");
		Mockito.when(serviceMock.uploadFile(Mockito.any(), Mockito.any(MultipartFile.class), Mockito.any())).thenReturn(response);
		ResponseEntity<?> res = accountControllerObj.uploadFile1("1",  Mockito.any(MultipartFile.class), doc);
		
		Assert.assertEquals(200, res.getStatusCodeValue());

	}

	@Test(expected = Exception.class)
	public void uploadFileFailureTest() throws Exception {
		FileUploadResponse response = new FileUploadResponse();
		response.setDocumentId("1");
		response.setDocumentSeq("agree");
		DocumentRequest doc = new DocumentRequest();
		doc.setDocumentId("1");
		doc.setDocumentSeq("agree");
		Mockito.when(serviceMock.uploadFile(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(response);
		ResponseEntity<?> res = accountControllerObj.uploadFile1("1", Mockito.any(), doc);
		Assert.assertNotSame(res.getBody(), response);
		Assert.assertNotSame(200, res.getStatusCodeValue());
	}
}
