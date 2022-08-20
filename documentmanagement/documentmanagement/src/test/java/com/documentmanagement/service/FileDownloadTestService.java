package com.documentmanagement.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;



import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class FileDownloadTestService {
	
	@InjectMocks
    private FileDownloadService fileDownloadService;
    
  @Mock
 private Resource resource;
    
    @Test
    public void getFileAsResourceTest() throws Exception
    {
    	Resource resources=getMockedresource();
		String accountId="test"; 
		String documentName="test.test"; 
	//	String Uripath="///C:/Document-Management/A01/Document1.docx";
	
		// Resource mockResource = Mockito.mock(Resource.class);
	 //  Mockito.when( resource.getURI()).thenReturn(value);
		Resource res = fileDownloadService.getFileAsResource(accountId,documentName);
		Assert.assertSame(documentName, res.getFilename());
    }
    
    
 
    @Test(expected = Exception.class)
	public void testGetByEmailWithCustomException() throws Exception
	{
    	Resource resources=getMockedresource();
    	String documentName="test";
    	 Mockito.when(resources.getFilename()).thenThrow(RuntimeException.class);
   Assert.assertNotSame("Incorrect file format",resources.getFilename() , documentName);
    	//String p="C:\\Document-Management\\test\test.test";
		//Path path = Paths.get(p); 
		
	//	Mockito.when(Files.notExists(path)).thenThrow(RuntimeException.class);
		
	//	Mockito.when(userRepository.findByEmailId(Mockito.any())).thenThrow(RuntimeException.class);
		
	//	Path paths = Paths.get(resource.getURI());	 
	//	Mockito.when(resources.))); 
	//	Path paths = Paths.get(resource.getURI());	
	//	Assert.assertEquals(path, resource.getURI());  
	}  
     
    
	private Resource getMockedresource() {
		Resource resource=new Resource()
				{
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
		return null;
	}

}

