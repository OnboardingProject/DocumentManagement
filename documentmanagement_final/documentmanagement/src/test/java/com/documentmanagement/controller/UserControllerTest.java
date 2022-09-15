package com.documentmanagement.controller;



import static org.mockito.Mockito.when;



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



import com.documentmanagement.exception.CustomException;
import com.documentmanagement.request.UserRequest;
import com.documentmanagement.response.UserResponse;
import com.documentmanagement.service.UserService;



import junit.framework.Assert;



/**
*
* UserController test class created by Ann- 212040
*
*/
@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
    @InjectMocks
    private UserController userControllerObj;
    @Mock
    private UserService serviceMock;



   /**
     * test case for controller of update document status
     * @throws Exception
     */
    @Test
    public void updateDocumentStatusTest() throws Exception {
        UserRequest userRequest = new UserRequest();
        userRequest.setUserId("U01");
        UserResponse response = new UserResponse();
        response.setUserId("U01");
        List<UserResponse> responseList = new ArrayList<UserResponse>();
        responseList.add(response);
        when(serviceMock.updateStatus(Mockito.any())).thenReturn(response);
        ResponseEntity<?> res = userControllerObj.updateDocumentStatus(userRequest);
        Assert.assertEquals(res.getBody(), response);
    }



   /**
     *
     * @throws Exception
     *//*
    @Test(expected = Exception.class)
    public void updateDocStatusTestwithInternalServerError() throws Exception {
        UserRequest userRequest = new UserRequest();
        userRequest.setUserId("U01");
        when(serviceMock.updateStatus(Mockito.any())).thenThrow(Exception.class);
        ResponseEntity<?> res = userControllerObj.updateDocumentStatus(userRequest);
        Assert.assertTrue(res.getStatusCode().equals(HttpStatus.INTERNAL_SERVER_ERROR));
    }



   *//**
     *
     * @throws Exception
     *//*
    @Test(expected = Exception.class)
    public void updateDocStatustwithCustomBadRequest() throws Exception {
        UserRequest userRequest = new UserRequest();
        userRequest.setUserId(null);
        when(serviceMock.updateStatus(Mockito.any())).thenThrow(CustomException.class);
        ResponseEntity<?> res = userControllerObj.updateDocumentStatus(userRequest);
        Assert.assertTrue(res.getStatusCode().equals(HttpStatus.BAD_REQUEST));
    }
    */
       
}