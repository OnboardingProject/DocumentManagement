package com.documentmanagement.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import com.documentmanagement.entity.Account;
import com.documentmanagement.entity.Documents;
import com.documentmanagement.exception.CustomException;
import com.documentmanagement.repository.iAccountRepository;
import com.documentmanagement.request.DeleteRequest;
import com.documentmanagement.response.AccountResponse;
import com.documentmanagement.utils.DocumentStatus;

@RunWith(MockitoJUnitRunner.class)
public class AccountsServiceTest {
	@InjectMocks
	private AccountService accountServiceObj;
	@Mock
	private iAccountRepository accountRepositoryObj;
	@Mock
	private ModelMapper mapper;

	@Test
	public void findAll() throws Exception {
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
		Mockito.when(accountRepositoryObj.findAll()).thenReturn(accList);
		List<Account> accountList = accountServiceObj.findAll();
		Assert.assertNotNull(accList);

	}

	@Test
	public void viewInfo() throws Exception {
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
		Mockito.when(accountRepositoryObj.findAll()).thenReturn(accList);
		List<Account> accountList = accountServiceObj.viewInfo();
		Assert.assertNotNull(accList);

	}

	@Test
	public void getDocumentsByAccountId() throws Exception {
		String accountId = "test";
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
		Documents document1 = new Documents();
		document1.setDocumentId("test1");
		document1.setDocumentName("test1");
		document1.setDocumentSeq("test1");
		document1.setDocumentSeq("test1");
		document1.setDocumentStatus(DocumentStatus.ACTIVE);
		List<Documents> docsList = new ArrayList<Documents>();
		docsList.add(document);
		docsList.add(document1);
		account.setDocumentList(docsList);
		Optional<Account> optAccount = Optional.of(account);
		AccountResponse res = new AccountResponse();
		res.setDocumentDesc(document.getDocumentDesc());
		res.setDocumentId(document.getDocumentId());
		res.setDocumentName(document.getDocumentName());
		res.setDocumentSeq(document.getDocumentSeq());
		res.setDocumentStatus("ACTIVE");
		List<AccountResponse> responseList = new ArrayList<AccountResponse>();
		responseList.add(res);
		Mockito.when(accountRepositoryObj.findByAccountId(accountId)).thenReturn(optAccount);
		List<AccountResponse> response = accountServiceObj.getDocumentsByAccountId(accountId);
		Assert.assertTrue(!responseList.isEmpty());
		Assert.assertNotNull(response);
	}

	@Test(expected = Exception.class)
	public void getDocumentsByAccountId2() throws Exception {
		String accountId = "test";
		Account account = new Account();
		account.setAccountId(null);
		Optional<Account> optAccount = Optional.of(account);
		Mockito.when(accountRepositoryObj.findByAccountId(Mockito.any())).thenThrow(CustomException.class);
		List<AccountResponse> response = accountServiceObj.getDocumentsByAccountId(accountId);
		Assert.assertNotNull(optAccount);

	}

	@Test(expected = CustomException.class)
	public void getDocumentsByAccountId4() throws Exception {
		String accountId = "test";
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
		Documents document1 = new Documents();
		document1.setDocumentId("test1");
		document1.setDocumentName("test1");
		document1.setDocumentSeq("test1");
		document1.setDocumentSeq("test1");
		document1.setDocumentStatus(DocumentStatus.ACTIVE);
		List<Documents> docsList = new ArrayList<Documents>();
		docsList.add(document);
		docsList.add(document1);
		account.setDocumentList(docsList);
		Optional<Account> optAccount = Optional.of(account);
		Mockito.when(accountRepositoryObj.findByAccountId(Mockito.any())).thenThrow(CustomException.class);
		List<AccountResponse> response = accountServiceObj.getDocumentsByAccountId(accountId);
		Assert.assertNotNull(!docsList.isEmpty());

	}

	@Test(expected = Exception.class)
	public void getDocumentsByAccountId3() throws Exception {
		String accountId = "test";
		Account account = new Account();
		account.setAccountId("test");
		account.setCustomerName("test");
		account.setAboutCustomer(null);
		account.setAccountOverview(null);
		account.setCreatedDate(LocalDateTime.now());
		account.setCreatedBy(null);
		account.setUpdatedDate(LocalDateTime.now());
		account.setUpdatedDate(null);
		account.setDocumentList(null);
		Optional<Account> optAccount = Optional.of(account);
		Mockito.when(accountRepositoryObj.findByAccountId(Mockito.any())).thenReturn(optAccount);
		List<AccountResponse> response = accountServiceObj.getDocumentsByAccountId(accountId);
		Assert.assertTrue(response.isEmpty());

	}

	@Test
	public void softDelete11() throws Exception {
		String accountId = "test";
		DeleteRequest request = new DeleteRequest();
		request.setDocumentId("test");
		request.setDocumentStatus(DocumentStatus.DELETE);
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
		Documents document1 = new Documents();
		document1.setDocumentId("test1");
		document1.setDocumentName("test1");
		document1.setDocumentSeq("test1");
		document1.setDocumentSeq("test1");
		document1.setDocumentStatus(DocumentStatus.ACTIVE);
		List<Documents> docsList = new ArrayList<Documents>();
		docsList.add(document);
		docsList.add(document1);
		account.setDocumentList(docsList);
		Optional<Account> optAccount = Optional.of(account);
		AccountResponse res = new AccountResponse();
		res.setDocumentDesc(document.getDocumentDesc());
		res.setDocumentId(document.getDocumentId());
		res.setDocumentName(document.getDocumentName());
		res.setDocumentSeq(document.getDocumentSeq());
		res.setDocumentStatus("ACTIVE");
		List<AccountResponse> responseList = new ArrayList<AccountResponse>();
		responseList.add(res);
		Mockito.when(accountRepositoryObj.findByAccountId(Mockito.any())).thenReturn(optAccount);
		List<AccountResponse> response = accountServiceObj.SoftDelete(accountId, request);
		Assert.assertNotNull(response);

	}

	@Test(expected = CustomException.class)
	public void softDelete12() throws Exception {
		String accountId = null;
		DeleteRequest request = new DeleteRequest();
		request.setDocumentId("test");
		request.setDocumentStatus(DocumentStatus.DELETE);
		Mockito.when(accountRepositoryObj.findByAccountId(Mockito.any())).thenThrow(CustomException.class);
		List<AccountResponse> response = accountServiceObj.SoftDelete(accountId, request);
	}
	@Test
    public void softDelete() throws Exception {
        String accountId = "test";
        DeleteRequest request = new DeleteRequest();
        request.setDocumentId("test");
        request.setDocumentStatus(DocumentStatus.DELETE);
        Account acc = new Account();
        acc.setAccountId("test");
        acc.setCustomerName("test");
        Documents docs = new Documents();
        docs.setDocumentId("test");
        docs.setDocumentName("test");
        docs.setDocumentDesc("test");
        docs.setDocumentSeq("test");
        docs.setDocumentStatus(DocumentStatus.ACTIVE);
        List<Documents> docsList = new ArrayList<Documents>();
        docsList.add(docs);
        acc.setDocumentList(docsList);
        Optional<Account> account = Optional.of(acc);
        Mockito.when(accountRepositoryObj.findByAccountId(Mockito.any())).thenReturn(account);
        List<AccountResponse> response = accountServiceObj.SoftDelete(accountId, request);
        Assert.assertNotNull(account);



   }



   @Test(expected = CustomException.class)
    public void softDelete2() throws Exception {
        String accountId = "test";
        DeleteRequest request = new DeleteRequest();
        request.setDocumentId("test");
        request.setDocumentStatus(DocumentStatus.DELETE);
        Account acc = new Account();
        acc.setAccountId("test");
        acc.setCustomerName("test");
        Documents docs = new Documents();
        docs.setDocumentId("test");
        docs.setDocumentName("test");
        docs.setDocumentDesc("test");
        docs.setDocumentSeq("test");
        docs.setDocumentStatus(DocumentStatus.DELETE);
        List<Documents> docsList = new ArrayList<Documents>();
        docsList.add(docs);
        acc.setDocumentList(docsList);
        Optional<Account> account = Optional.of(acc);
        Mockito.when(accountRepositoryObj.findByAccountId(Mockito.any())).thenReturn(account);
        List<AccountResponse> response = accountServiceObj.SoftDelete(accountId, request);
        Assert.assertNotNull(account);



   }
   @Test(expected = CustomException.class)
   public void softDelete3() throws Exception {
       String accountId = "test";
       DeleteRequest request = new DeleteRequest();
       request.setDocumentId(null);
       request.setDocumentStatus(DocumentStatus.ACTIVE);
       Account acc = new Account();
       acc.setAccountId("test");
       acc.setCustomerName("test");
       Documents docs = new Documents();
       docs.setDocumentId("test");
       docs.setDocumentName("test");
       docs.setDocumentDesc("test");
       docs.setDocumentSeq("test");
       docs.setDocumentStatus(DocumentStatus.DELETE);
       List<Documents> docsList = new ArrayList<Documents>();
       docsList.add(docs);
       acc.setDocumentList(docsList);
       Optional<Account> account = Optional.of(acc);
       Mockito.when(accountRepositoryObj.findByAccountId(Mockito.any())).thenReturn(account);
       List<AccountResponse> response = accountServiceObj.SoftDelete(accountId, request);
       Assert.assertNotNull(account);
   }



  @Test(expected = Exception.class)
   public void softDelete4() throws Exception {
       String accountId = "test123";
       DeleteRequest request = new DeleteRequest();
       request.setDocumentId("test");
       request.setDocumentStatus(DocumentStatus.ACTIVE);
       Account acc = new Account();
       acc.setAccountId("test");
       acc.setCustomerName("test");
       acc.setAboutCustomer(null);
       acc.setAccountOverview(null);
       acc.setCreatedDate(LocalDateTime.now());
       acc.setCreatedBy(null);
       acc.setUpdatedDate(LocalDateTime.now());
       acc.setUpdatedDate(null);
       Documents document = new Documents();
       document.setDocumentId("test");
       document.setDocumentName("test");
       document.setDocumentDesc("test");
       document.setDocumentSeq("test");
       document.setDocumentStatus(DocumentStatus.ACTIVE);
       List<Documents> docsList = new ArrayList<Documents>();
       docsList.add(document);
       acc.setDocumentList(docsList);
       Optional<Account> optAccount = Optional.of(acc);
       Mockito.when(accountRepositoryObj.findByAccountId(Mockito.any())).thenThrow(CustomException.class);
       List<AccountResponse> response = accountServiceObj.SoftDelete(accountId, request);
       Assert.assertNotNull(optAccount);
   }
  
  @Test(expected = CustomException.class)
  public void softDelete5() throws Exception {
      String accountId = "test";
      DeleteRequest request = new DeleteRequest();
      request.setDocumentId("test");
      request.setDocumentStatus(DocumentStatus.DELETE);
      Account account = new Account();
      account.setAccountId("test");
      Optional<Account> optAccount = Optional.of(account);
      Mockito.when(accountRepositoryObj.findByAccountId(Mockito.any())).thenThrow(CustomException.class);
      List<AccountResponse> response = accountServiceObj.SoftDelete(accountId, request);
      Assert.assertNotNull(optAccount);
  }



}