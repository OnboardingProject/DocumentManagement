package com.documentmanagement.controller;



import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.documentmanagement.entity.Account;
import com.documentmanagement.entity.Documents;
import com.documentmanagement.exception.CustomException;
import com.documentmanagement.request.DeleteRequest;
import com.documentmanagement.response.AccountResponse;
import com.documentmanagement.service.AccountService;
import com.documentmanagement.utils.DocumentStatus;



import junit.framework.Assert;



@RunWith(MockitoJUnitRunner.class)
public class AccountControllerTest {
    @InjectMocks
    private AccountController accountControllerObj;
    @Mock
    private AccountService accountServiceObj;
    
@Test
public void findAll()throws Exception{
    
    Account account = new Account();
    account.setAccountId("test");
    account.setCustomerName("test");
    account.setAboutCustomer(null);
    account.setAccountOverview(null);
    account.setCreatedDate(LocalDateTime.now());
    account.setCreatedBy(null);
    account.setUpdatedDate(LocalDateTime.now());
    account.setUpdatedDate(null);
    Documents document = new Documents();
    document.setDocumentId("test");
    document.setDocumentName("test");
    document.setDocumentSeq("test");
    document.setDocumentSeq("test");
    document.setDocumentStatus(DocumentStatus.ACTIVE);
    List<Documents> docsList = new ArrayList<Documents>();
    docsList.add(document);
    account.setDocumentList(docsList);
    List<Account> accList = new ArrayList<Account>();
    accList.add(account);
    Mockito.when(accountServiceObj.findAll()).thenReturn(accList);
    List<Account> accounts=accountControllerObj.getAllAccounts();
    Assert.assertEquals(accounts, accList);
}



@Test
public void insertingData()throws Exception{
    
    Account account = new Account();
    account.setAccountId("test");
    account.setCustomerName("test");
    account.setAboutCustomer(null);
    account.setAccountOverview(null);
    account.setCreatedDate(LocalDateTime.now());
    account.setCreatedBy(null);
    account.setUpdatedDate(LocalDateTime.now());
    account.setUpdatedDate(null);
    Documents document = new Documents();
    document.setDocumentId("test");
    document.setDocumentName("test");
    document.setDocumentSeq("test");
    document.setDocumentSeq("test");
    document.setDocumentStatus(DocumentStatus.ACTIVE);
    List<Documents> docsList = new ArrayList<Documents>();
    docsList.add(document);
    account.setDocumentList(docsList);
    List<Account> accList = new ArrayList<Account>();
    accList.add(account);
    Mockito.when(accountServiceObj.viewInfo()).thenReturn(accList);
    List<Account> accounts=accountControllerObj.viewDocInfo();
    Assert.assertEquals(accounts, accList);
}



   @Test
    public void getDocumentByAccountId() throws Exception {
        String accountId = "test";
        AccountResponse response = new AccountResponse();
        response.setDocumentId("test");
        response.setDocumentName("test");
        response.setDocumentDesc("test");
        response.setDocumentSeq("test");
        response.setDocumentStatus("test");
        List<AccountResponse> responseList = new ArrayList<AccountResponse>();
        responseList.add(response);
        Mockito.when(accountServiceObj.getDocumentsByAccountId(Mockito.anyString())).thenReturn(responseList);
        ResponseEntity<?> account = accountControllerObj.getDocumentsAccountById(accountId);
        Assert.assertSame(responseList, account.getBody());



   }



   @Test(expected = Exception.class)
    public void getDocumentByAccountIdWithErrorWithBadRequest() throws Exception {
        String accountId = "";



       Mockito.when(accountServiceObj.getDocumentsByAccountId(Mockito.anyString())).thenThrow(Exception.class);
        ResponseEntity<?> account = accountControllerObj.getDocumentsAccountById(accountId);
        Assert.assertSame(account.getBody(), account.getStatusCode().BAD_REQUEST);
    }



   @Test(expected = Exception.class)
    public void getDocumentByAccountIdWithError() throws Exception {
        String accountId = "test";
        Mockito.when(accountServiceObj.getDocumentsByAccountId(Mockito.anyString())).thenThrow(CustomException.class);
        ResponseEntity<?> account = accountControllerObj.getDocumentsAccountById(accountId);
        Assert.assertSame(account.getBody(), account.getStatusCode().BAD_REQUEST);
    }



   @Test(expected = Exception.class)
    public void getDocumentByAccountIdWithInternalServerError() throws Exception {
        String accountId = "test";
        Mockito.when(accountServiceObj.getDocumentsByAccountId(Mockito.anyString())).thenThrow(CustomException.class);
        ResponseEntity<?> account = accountControllerObj.getDocumentsAccountById(accountId);
        Assert.assertTrue(account.getStatusCode().equals(HttpStatus.INTERNAL_SERVER_ERROR));



   }
    
    @Test
    public void softDeleteByAccountId() throws Exception{
        String accountId="test";
        DeleteRequest request= new DeleteRequest();
        request.setDocumentId("test");
        request.setDocumentStatus(DocumentStatus.DELETE);
        AccountResponse response = new AccountResponse();
        response.setDocumentId("test");
        response.setDocumentName("test");
        response.setDocumentDesc("test");
        response.setDocumentSeq("test");
        response.setDocumentStatus("test");
        List<AccountResponse> responseList = new ArrayList<AccountResponse>();
        responseList.add(response);
        Mockito.when(accountServiceObj.SoftDelete(Mockito.any(), Mockito.any())).thenReturn(responseList);
        ResponseEntity<?> account = accountControllerObj.softDeleteByAccountId(accountId, request);
        Assert.assertEquals(responseList, account.getBody());
    }
    @Test
    public void softDeleteByAccountId2() throws Exception{
        String accountId="test";
        DeleteRequest request= new DeleteRequest();
        request.setDocumentId("test");
        request.setDocumentStatus(DocumentStatus.ACTIVE);
        AccountResponse response = new AccountResponse();
        response.setDocumentId("test");
        response.setDocumentName("test");
        response.setDocumentDesc("test");
        response.setDocumentSeq("test");
        response.setDocumentStatus("test");
        List<AccountResponse> responseList = new ArrayList<AccountResponse>();
        responseList.add(response);
        Mockito.when(accountServiceObj.SoftDelete(Mockito.any(), Mockito.any())).thenReturn(responseList);
        ResponseEntity<?> account = accountControllerObj.softDeleteByAccountId(accountId, request);
        Assert.assertEquals(responseList, account.getBody());
    }
    @Test
    public void softDeleteByAccountIdWithError() throws Exception{
        String accountId="test";
        List<AccountResponse> responseList = new ArrayList<AccountResponse>();
        DeleteRequest request= new DeleteRequest();
        request.setDocumentId(null);
        request.setDocumentStatus(null);
        Mockito.when(accountServiceObj.SoftDelete(Mockito.any(), Mockito.any())).thenReturn(responseList);
        ResponseEntity<?> account = accountControllerObj.softDeleteByAccountId(accountId, request);
        Assert.assertSame(responseList, account.getBody());
    }
}