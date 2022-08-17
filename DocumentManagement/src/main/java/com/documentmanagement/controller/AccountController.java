package com.documentmanagement.controller;


import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.documentmanagement.entity.Account;
import com.documentmanagement.request.DocumentRequest;
import com.documentmanagement.response.FileUploadResponse;
import com.documentmanagement.service.AccountService;

import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


/**
 * 
 * Account Controller class created by swathi
 *
 */
@RestController
@Validated
public class AccountController {
	@Autowired
	AccountService accountService;
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

	/**
	 * 
	 * @return the statically inserted account details
	 */
	@GetMapping("/account")
	@Operation(summary = "Inserting the account details statically ", description = "Inserting the account details statically", tags = "AccountAPI")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Inserted the account details"),
			@ApiResponse(responseCode = "500", description = "Internal Server Error"),
			@ApiResponse(responseCode = "400", description = "Bad Request") })
	public List<Account> insertAccount() {
		logger.info("Geting all account details ");
		return accountService.insertAccount();

	}
	/**
	 * 
	 * @param accountId
	 * @param multipartFile
	 * @param doc
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value="/account/documentId/upload",consumes= {MediaType.MULTIPART_FORM_DATA_VALUE,MediaType.APPLICATION_OCTET_STREAM_VALUE,MediaType.APPLICATION_JSON_VALUE})
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Inserted the account details"),
			@ApiResponse(responseCode = "500", description = "Internal Server Error"),
			@ApiResponse(responseCode = "400", description = "Bad Request") })
    public ResponseEntity<?> uploadFile1(@RequestParam (name="accountId",required=true) String accountId,
    		 @RequestPart("file") MultipartFile multipartFile,@Valid @RequestPart  DocumentRequest  doc) throws Exception
    {
		FileUploadResponse response;
		response= accountService.uploadFile(accountId,multipartFile,doc);
		return new ResponseEntity<>(response, HttpStatus.OK);
              
        
    }
	/**
	 * 
	 * @return
	 */
	@GetMapping("/getUser")
	public List<Account> userInfo() {
		
		return accountService.getUserInfo();
	}
	
	

}
