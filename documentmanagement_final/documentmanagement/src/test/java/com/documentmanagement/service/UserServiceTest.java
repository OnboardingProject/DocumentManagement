package com.documentmanagement.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.documentmanagement.entity.AccountDocument;
import com.documentmanagement.entity.User;
import com.documentmanagement.exception.CustomException;
import com.documentmanagement.repository.iUserRepository;
import com.documentmanagement.request.UserRequest;
import com.documentmanagement.response.UserResponse;
import com.documentmanagement.utils.docStatus;

import junit.framework.Assert;

/***
*
* service test class created by Ann- 212040
*
*/
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @InjectMocks
    UserService userService;
    @Mock
    iUserRepository userRepository;



   /**
     * test case for update function
     *
     * @throws Exception
     */
    @Test(expected=Exception.class)
    public void updateStatusTest() throws Exception {
        UserRequest userRequest = new UserRequest();
        userRequest.setUserId("U02");
        userRequest.setDocumentId("D02");
        userRequest.setDocumentStatus(docStatus.agree);
        User user = new User();
        user.setUserId("U02");
        user.setUserName("test");
        user.setAccountName("test");
        user.setFirstName("test");
        user.setLastName("test");
        user.setEmailId("test");
        user.setPhoneNo("test");
        user.setDesignation("test");
        user.setCreatedOn(LocalDateTime.now());
        user.setCreatedBy("test");
        user.setLastUpdatedOn(LocalDateTime.now());
        user.setLastUpdatedBy("test");
        user.setRoleId("test");
        AccountDocument accountDocument = new AccountDocument();
        accountDocument.setDocumentId("D02");
        accountDocument.setDocumentStatus(docStatus.disagree);
        List<AccountDocument> documentList = new ArrayList<AccountDocument>();
        documentList.add(accountDocument);
        user.setAccountDocuments(documentList);
        Optional<User> userAccount = Optional.of(user);
        UserResponse userResponse=new UserResponse();
        userResponse.setUserId("U02");
        userResponse.setDocumentId("D02");
        userResponse.setDocumentStatus(docStatus.agree);
        List<UserResponse> responseList=new ArrayList<UserResponse>();
        responseList.add(userResponse);
        Mockito.when(userRepository.findByUserId(Mockito.any())).thenReturn(userAccount);
        UserResponse response = userService.updateStatus(userRequest);
        Assert.assertNotNull(response);
    }
    @Test(expected=Exception.class)
    public void updateStatusSameDocStatusTest() throws Exception {
        UserRequest userRequest = new UserRequest();
        userRequest.setUserId("U02");
        userRequest.setDocumentId("D02");
        userRequest.setDocumentStatus(docStatus.agree);
        AccountDocument accountDocument = new AccountDocument();
        accountDocument.setDocumentId("D02");
        accountDocument.setDocumentStatus(docStatus.agree);
        User user = new User();
        user.setUserId("U01");
        user.setUserName("test");
        user.setAccountName("test");
        user.setFirstName("test");
        user.setLastName("test");
        user.setEmailId("test");
        user.setPhoneNo("test");
        user.setDesignation("test");
        user.setCreatedOn(LocalDateTime.now());
        user.setCreatedBy("test");
        user.setLastUpdatedOn(LocalDateTime.now());
        user.setLastUpdatedBy("test");
        user.setRoleId("test");
        List<AccountDocument> documentList = new ArrayList<AccountDocument>();
        documentList.add(accountDocument);
        user.setAccountDocuments(documentList);
        Optional<User> userAccount = Optional.of(user);
        UserResponse userResponse=new UserResponse();
        userResponse.setUserId("U02");
        userResponse.setDocumentId("D02");
        userResponse.setDocumentStatus(docStatus.agree);
        List<UserResponse> responseList=new ArrayList<UserResponse>();
        responseList.add(userResponse);
        Mockito.when(userRepository.findByUserId(Mockito.any())).thenReturn(userAccount);
        UserResponse response = userService.updateStatus(userRequest);
        Assert.assertNotNull(response);
    }
    @Test(expected=Exception.class)
    public void updateStatusNoDocTest() throws Exception {
        UserRequest userRequest = new UserRequest();
        userRequest.setUserId("U01");
        userRequest.setDocumentId("D08");
        userRequest.setDocumentStatus(docStatus.agree);
        AccountDocument accountDocument = new AccountDocument();
        accountDocument.setDocumentId("D02");
        accountDocument.setDocumentStatus(docStatus.agree);
        User user = new User();
        user.setUserId("U01");
        user.setUserName("test");
        user.setAccountName("test");
        user.setFirstName("test");
        user.setLastName("test");
        user.setEmailId("test");
        user.setPhoneNo("test");
        user.setDesignation("test");
        user.setCreatedOn(LocalDateTime.now());
        user.setCreatedBy("test");
        user.setLastUpdatedOn(LocalDateTime.now());
        user.setLastUpdatedBy("test");
        user.setRoleId("test");
        List<AccountDocument> documentList = new ArrayList<AccountDocument>();
        documentList.add(accountDocument);
        user.setAccountDocuments(documentList);
        Optional<User> userAccount = Optional.of(user);
        Mockito.when(userRepository.findByUserId(Mockito.any())).thenReturn(userAccount);
        UserResponse response = userService.updateStatus(userRequest);
        Assert.assertNotNull(response);
    }
    @Test(expected=CustomException.class)
    public void updateStatusNoUserTest() throws Exception {
        UserRequest userRequest = new UserRequest();
        userRequest.setUserId("U09");
        userRequest.setDocumentId("D02");
        userRequest.setDocumentStatus(docStatus.agree);
        AccountDocument accountDocument = new AccountDocument();
        accountDocument.setDocumentId("D02");
        accountDocument.setDocumentStatus(docStatus.agree);
        User user = new User();
        user.setUserId("U01");
        user.setUserName("test");
        user.setAccountName("test");
        user.setFirstName("test");
        user.setLastName("test");
        user.setEmailId("test");
        user.setPhoneNo("test");
        user.setDesignation("test");
        user.setCreatedOn(LocalDateTime.now());
        user.setCreatedBy("test");
        user.setLastUpdatedOn(LocalDateTime.now());
        user.setLastUpdatedBy("test");
        user.setRoleId("test");
        List<AccountDocument> documentList = new ArrayList<AccountDocument>();
        documentList.add(accountDocument);
        user.setAccountDocuments(documentList);
        Optional<User> userAccount = Optional.of(user);
        Mockito.when(userRepository.findByUserId(Mockito.any())).thenReturn(userAccount);
        UserResponse response = userService.updateStatus(userRequest);
        Assert.assertNotNull(response);
    }
    @Test(expected =Exception.class)
    public void updateStatusDocNullExceptionTest() throws Exception {
        UserRequest userRequest = new UserRequest();
        userRequest.setUserId("U01");
        userRequest.setDocumentId(null);
        userRequest.setDocumentStatus(docStatus.agree);
        User user = new User();
        user.setUserId("U01");
        user.setUserName("test");
        user.setAccountName("test");
        user.setFirstName("test");
        user.setLastName("test");
        user.setEmailId("test");
        user.setPhoneNo("test");
        user.setDesignation("test");
        user.setCreatedOn(LocalDateTime.now());
        user.setCreatedBy("test");
        user.setLastUpdatedOn(LocalDateTime.now());
        user.setLastUpdatedBy("test");
        user.setRoleId("test");
        AccountDocument accountDocument=new AccountDocument();
        accountDocument.setDocumentId("D01");
        List<AccountDocument> documentList = new ArrayList<AccountDocument>();
        documentList.add(accountDocument);
        user.setAccountDocuments(documentList);
        Optional<User> userAccount = Optional.of(user);
        Mockito.when(userRepository.findByUserId(Mockito.any())).thenReturn(userAccount);
        UserResponse userResponse = userService.updateStatus(userRequest);
    }
    @Test(expected = Exception.class)
    public void updateStatusUserNullExceptionTest() throws Exception {
        UserRequest userRequest = new UserRequest();
        userRequest.setUserId(null);
        userRequest.setDocumentId("D01");
        userRequest.setDocumentStatus(docStatus.agree);
        User user = new User();
        user.setUserId("U01");
        user.setUserName("test");
        user.setAccountName("test");
        user.setFirstName("test");
        user.setLastName("test");
        user.setEmailId("test");
        user.setPhoneNo("test");
        user.setDesignation("test");
        user.setCreatedOn(LocalDateTime.now());
        user.setCreatedBy("test");
        user.setLastUpdatedOn(LocalDateTime.now());
        user.setLastUpdatedBy("test");
        user.setRoleId("test");
        Optional<User> userDetails=Optional.of(user);
        Mockito.when(userRepository.findByUserId(Mockito.any())).thenReturn(userDetails);
        UserResponse userResponse = userService.updateStatus(userRequest);
    }
    


}