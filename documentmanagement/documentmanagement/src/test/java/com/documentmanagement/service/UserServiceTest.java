package com.documentmanagement.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.documentmanagement.entity.User;
import com.documentmanagement.repository.iUserRepository;
import com.documentmanagement.response.UserResponse;

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

	@Test
	public void viewInfoTest()
	{
		User testUser=new User();
		testUser.setUserId("U01");
		UserResponse userResponse=new UserResponse();
		userResponse.setUserId("U01");
		Mockito.when(userRepository.save(Mockito.any())).thenReturn(testUser);
		Assert.assertNotSame(userService.viewInfo(), ("test@gmail.com"));
	}
	
	/*@Test
	public void updateStatusTest()
	{
		
	}
*/
}
