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
import org.junit.jupiter.api.io.TempDir;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;



import com.documentmanagement.exception.CustomException;



import junit.framework.Assert;



@RunWith(MockitoJUnitRunner.class)
public class FileDownloadTestService {



   @InjectMocks
    private FileDownloadService fileDownloadService;



   @Mock
    private Resource resource;
    
    @TempDir
    Path tempDir;
    
    @Value("${file.upload-dir}")
    private String basePath;




    @Test(expected = Exception.class)
    public void testIncorrectFormat() throws Exception {
    
        String documentName = "test";
        Mockito.when(resource.getFilename()).thenThrow(CustomException.class);
        Resource reponse=fileDownloadService.getFileAsResource("1",documentName );
        Assert.assertNotSame("Incorrect file format", resource.getFilename(), reponse.getFilename());
    }
    
    @Test(expected = IOException.class)
    public void testInternalServerError() throws IOException
    {
        String accountId = "A01";
        String documentName = "test.test";  
        Mockito.when(resource.getInputStream()).thenThrow(RuntimeException.class);
        Resource reponse=fileDownloadService.getFileAsResource(accountId, documentName);
        Assert.assertTrue(reponse.equals(HttpStatus.INTERNAL_SERVER_ERROR));
    }
    
    
    @Test(expected = Exception.class)
    public void testPath() throws Exception {
        
        String accountId = "";
        String documentName = "";     
        
        /*String directoryPath = new StringBuilder(basePath).append("\\").append(accountId).append("\\")
                .append(documentName).toString();     
        final Path path = Paths.get(directoryPath);
        Mockito.when(Files.notExists(path)).thenThrow(CustomException.class);*/
        
        Mockito.when(resource.getFilename()).thenThrow(CustomException.class);
        Resource reponse=fileDownloadService.getFileAsResource(accountId,documentName );
        
        Assert.assertNotSame("test.test", reponse.getFilename());



   }



   @Test(expected = Exception.class)
    public void testPathNotFound() throws Exception {
        
        Path tempFile = tempDir.resolve("test-etc-hosts.txt");
          try (MockedStatic<Paths> mocked = mockStatic(Paths.class)) {
              mocked.when(() -> Paths.get("/etc/hosts"))
              .thenReturn(tempFile);



     
          }
          }



    
    
    private MockedStatic<Paths> mockStatic(Class<Paths> class1) {
        // TODO Auto-generated method stub
        return null;
    }



   private Resource getMockedresource() {
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
        return null;
    }



}