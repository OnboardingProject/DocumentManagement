package com.documentmanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.documentmanagement.entity.User;
import com.documentmanagement.request.UserRequest;
import com.documentmanagement.response.UserResponse;
import com.documentmanagement.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 * 
 * user controller class created by Ann- 212040
 *
 */
@RestController
@RequestMapping("/")
public class UserController {

	@Autowired
	UserService userService;

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	/**
	 * 
	 * @return static data about user
	 */
	@Operation(summary = "Get list of users with document list ", description = "Get the list of users with their document list", tags = "GetAPI")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Found the list of users"),
			@ApiResponse(responseCode = "500", description = "Internal Server Error"),
			@ApiResponse(responseCode = "400", description = "Not Found Error") })
	@GetMapping("/users")
	public List<User> viewUserInfo() {
		logger.info("Fetching all users with document info");
		return userService.viewInfo();
	}

	/**
	 * 
	 * @param userRequest
	 * @return UserResponse
	 */
	
	@Operation(summary = "Update the list of users with document status ", description = "Updating document status", tags = "UpdateAPI")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Updated the document status"),
			@ApiResponse(responseCode = "500", description = "Internal Server Error"),
			@ApiResponse(responseCode = "400", description = "Not Found Error") })
	@PutMapping("/user/accountdocument")

	public ResponseEntity<?> updateDocumentStatus(@Valid @RequestBody UserRequest userRequest) throws Exception {
		logger.info("Fetching updated document status of ",userRequest.getUserId());
		UserResponse userResponse;
		userResponse=userService.updateStatus(userRequest);
		return new ResponseEntity<UserResponse>(userResponse,HttpStatus.OK);
		

	}

	/**
	 * 
	 * @return
	 *//*
	@Operation(summary = "Delete DB ", description = "Delete the info in DB", tags = "DeleteAPI")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Empty DB"),
			@ApiResponse(responseCode = "500", description = "Internal Server Error"),
			@ApiResponse(responseCode = "400", description = "Not Found Error") })
	@DeleteMapping("/delete/account")
	public List<User> deleteInfo() {
		logger.info("Returning empty database");
		return userService.deleteInfo();
	}*/

}
