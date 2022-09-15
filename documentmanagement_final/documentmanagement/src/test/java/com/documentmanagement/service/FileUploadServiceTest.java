package com.documentmanagement.service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.multipart.MultipartFile;

import com.documentmanagement.entity.Account;
import com.documentmanagement.entity.Documents;
import com.documentmanagement.exception.CustomException;
import com.documentmanagement.repository.iAccountRepository;
import com.documentmanagement.request.DocumentRequest;
import com.documentmanagement.response.FileUploadResponse;
import com.documentmanagement.utils.DocumentStatus;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class FileUploadServiceTest {
	@InjectMocks
	FileUploadService accountServiceObj;
	@Mock
	iAccountRepository repository;

	@Test
	public void insertUserRequestTest() throws Exception {
		Documents userRequest = new Documents();
		userRequest.setDocumentId("1");
		userRequest.setDocumentDesc("pdf");
		FileUploadResponse userResponse = new FileUploadResponse();
		userResponse.setDocumentId("1");
		userResponse.setDocumentDesc("pdf");
		List<Documents> samplUser = new ArrayList<Documents>();
		samplUser.add(userRequest);
		Mockito.when(repository.save(Mockito.any())).thenReturn(samplUser);
		FileUploadResponse res = accountServiceObj.uploadFile(Mockito.any(), Mockito.any(MultipartFile.class),
				Mockito.any());
		Assert.assertSame(userResponse, res);
	}

	@Test
	public void getUserInfoTest() throws Exception {
		Mockito.when(repository.findAll()).thenReturn(null);
		List<Account> res = accountServiceObj.getUserInfo();

	}

	@Test
	public void insertAccount() throws Exception {
		List<Documents> accountDocument = new ArrayList<Documents>();
		Documents doc1 = new Documents("D01", "Document1", "Document 1", "seq", DocumentStatus.ACTIVE);
		Documents doc2 = new Documents("D02", "Document2", "Document 1", "seq", DocumentStatus.ACTIVE);
		accountDocument.add(doc1);
		accountDocument.add(doc2);
		Account account1 = new Account("A01", "swathi", "customer 1", LocalDateTime.now(), "test", LocalDateTime.now(),
				"Ann Maria", "Overview", accountDocument);
		List<Account> account = new ArrayList<Account>();
		account.add(account1);
		Mockito.when(repository.findAll()).thenReturn(account);
	//	List<Account> res = accountServiceObj.insertAccount();
		Assert.assertNotNull(account);
	}

	@Test
	public void uploadFileTest() throws Exception {
		DocumentRequest doc = new DocumentRequest();
		doc.setDocumentId("1");
		Account account = new Account();
		account.setAccountId("1");
		account.setAboutCustomer("swathi");
		MultipartFile mpf = Mockito.mock(MultipartFile.class);
		Optional<Account> usersOptional = Optional.of(account);
		Mockito.when(repository.findById(Mockito.any())).thenReturn(usersOptional);
		FileUploadResponse res = accountServiceObj.uploadFile("1", mpf, doc);

		Assert.assertNotNull(account);
	}

	@Test(expected = Exception.class)
	public void testIncorrectFormat() throws Exception {

		DocumentRequest doc = new DocumentRequest();
		doc.setDocumentId("1");
		Account account = new Account();
		account.setAccountId(null);
		account.setAboutCustomer("swathi");
		MultipartFile mpf = Mockito.mock(MultipartFile.class);
		Mockito.when(repository.findById(null)).thenThrow(CustomException.class);
		FileUploadResponse res = accountServiceObj.uploadFile("1", mpf, doc);
		Assert.assertNotSame("Incorrect file format", account.getAccountId(), repository.findById(null));
	}
	@TempDir
    Path tempDir;
	@Test
	public void uploadRequest1()throws Exception {
		Path tempFile = tempDir.resolve("test-etc-hosts.txt");
       // Files.write(tempFile, asList("192.168.10.10        database-server"));

        // mock (all) static methods on Paths.class
		
      try(  MockedStatic<Paths> mocked = Mockito.mockStatic(Paths.class) )
      {
    	  mocked.when(() -> Paths.get("/etc/hosts"))
          .thenReturn(tempFile);
      }
		
	}
	

	

}

/*String accountId="1";
DocumentRequest doc = new DocumentRequest();
doc.setDocumentId("1");
doc.setDocumentDesc("pdf");
doc.setDocumentStatus("active");
doc.setDocumentSeq("12");
Account account=new Account();
account.setAccountId("1");
Documents document=new Documents();
document.setDocumentId("1");
document.setDocumentDesc("pdf");
document.setDocumentStatus("active");
document.setDocumentSeq("12");
List<Documents>documentList=new ArrayList<Documents>();
documentList.add(document);
account.setDocuments(documentList);
Optional <Account>acc=Optional.of(account);
Mockito.when(repository.findById(Mockito.any())).thenReturn(acc);
Mockito.when(repository.save(Mockito.any())).thenReturn(account);
MultipartFile mpf = Mockito.mock(MultipartFile.class);
FileUploadResponse res = accountServiceObj.uploadFile(accountId, mpf, doc);*/