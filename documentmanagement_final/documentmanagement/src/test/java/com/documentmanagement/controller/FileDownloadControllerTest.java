package com.documentmanagement.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.documentmanagement.service.FileDownloadService;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class FileDownloadControllerTest {
	@InjectMocks
	private FileDownloadController fileControllerObj;

	@Mock
	private FileDownloadService fileServiceMock;

	@Test
	public void testDownloadFileSucess() throws Exception {

		Resource resource = getMockedresource();
		String accountId = "test";
		String documentName = "test.test";
		Mockito.when(fileServiceMock.getFileAsResource(Mockito.anyString(), Mockito.anyString())).thenReturn(resource);
		ResponseEntity<?> res = fileControllerObj.downloadFile(accountId, documentName);
		Assert.assertEquals(res.getBody(), resource);
		Assert.assertEquals(200, res.getStatusCodeValue());
		Assert.assertEquals(resource.getFilename(), documentName);
	}

	@Test
	public void testDownloadFileNotFound() throws Exception {

		Resource resource = getMockedresource();
		String accountId = "test1";
		String documentName = "test123.test";
		Mockito.when(fileServiceMock.getFileAsResource(Mockito.anyString(), Mockito.anyString())).thenReturn(resource);
		ResponseEntity<?> res = fileControllerObj.downloadFile(accountId, documentName);
		Assert.assertNotSame(res.getBody(), resource.getFilename());

	}

	@Test(expected = Exception.class)
	public void testDownloadFileWithInternalError() throws Exception {

		Resource resource = getMockedresource();
		String accountId = "test";
		String documentName = "test.test";
		Mockito.when(fileServiceMock.getFileAsResource(Mockito.anyString(), Mockito.anyString()))
				.thenThrow(RuntimeException.class);
		ResponseEntity<?> res = fileControllerObj.downloadFile(accountId, documentName);
		Assert.assertTrue(res.getStatusCode().equals(HttpStatus.INTERNAL_SERVER_ERROR));
	}

	@Test(expected = Exception.class)
	public void testDownloadFileWithBadRequestError() throws Exception {

		Resource resource = getMockedresource();
		String accountId = "test";
		String documentName = "test.test";
		Mockito.when(fileServiceMock.getFileAsResource(Mockito.anyString(), Mockito.anyString()))
				.thenThrow(RuntimeException.class);
		ResponseEntity<?> res = fileControllerObj.downloadFile(accountId, documentName);
		Assert.assertTrue(res.getStatusCode().equals(HttpStatus.BAD_REQUEST));
	}

	private Resource getMockedresource() {
		// TODO Auto-generated method stub
		Resource resource = new Resource() {

			@Override
			public InputStream getInputStream() throws IOException {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public long contentLength() throws IOException {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public Resource createRelative(String relativePath) throws IOException {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean exists() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public String getDescription() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public File getFile() throws IOException {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getFilename() {
				// TODO Auto-generated method stub
				return "test.test";
			}

			@Override
			public URI getURI() throws IOException {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public URL getURL() throws IOException {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public long lastModified() throws IOException {
				// TODO Auto-generated method stub
				return 0;
			}

		};
		return resource;
	}

}
