package com.documentmanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.documentmanagement.entity.Account;
import com.documentmanagement.request.DeleteRequest;
import com.documentmanagement.request.UserRequest;
import com.documentmanagement.response.AccountResponse;
import com.documentmanagement.response.UserResponse;
import com.documentmanagement.service.AccountService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 *
 * @author 211458
 *
 */
@RestController
@RequestMapping("/")
public class AccountController {
	@Autowired
	private AccountService accountService;

	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

	/**
	 * method to get all details
	 *
	 * @return find all
	 */

	@Operation(summary = "Get list of accounts with document list ", description = "Get the list of accounts with their document list", tags = "CreateAPI")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Found the list "),
			@ApiResponse(responseCode = "500", description = "Internal Server Error"),
			@ApiResponse(responseCode = "400", description = "Not Found Error") })
	@GetMapping("/account")
	public List<Account> getAllAccounts() {
		return accountService.findAll();
	}

	/**
	 * method for inserting the data
	 *
	 * @return viewInfo
	 */
	@Operation(summary = "inserting and Getting list of accounts with document list ", description = "inserting and Getting the list of accounts with their document list", tags = "CreateAPI")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Found the list"),
			@ApiResponse(responseCode = "500", description = "Internal Server Error"),
			@ApiResponse(responseCode = "400", description = "Not Found Error") })
	@GetMapping("/insertAccounts")
	public List<Account> viewDocInfo() {
		logger.info("Fetching all users with document info");
		return accountService.viewInfo();
	}

	/**
	 * Method to get all documents for particular account
	 *
	 * @param accountId
	 * @return responseList
	 * @throws Exception
	 */
	@Operation(summary = "Get documents by accountId ", description = "Get the documents of the user by accountId", tags = "FindDocumentByAccountIdAPI")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Found the accountId"),
			@ApiResponse(responseCode = "500", description = "Internal Server Error"),
			@ApiResponse(responseCode = "400", description = "Not Found Error") })
	@GetMapping("/documents/{accountId}/documents")
	public ResponseEntity<?> getDocumentsAccountById(@Valid @PathVariable String accountId) throws Exception {
		logger.info("getting the documents by accountId : {}", accountId);
		List<AccountResponse> responseList = accountService.getDocumentsByAccountId(accountId);
		return new ResponseEntity<>(responseList, HttpStatus.OK);

	}

	/**
	 * method for soft delete the document
	 *
	 * @param accountId
	 * @param request
	 * @return
	 * @throws Exception
	 */

	@Operation(summary = "Get list of document by accountId and Deleting ", description = "Get list of document by accountId and doing soft delete", tags = "SoftDeleteAPI")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Found the list of users"),
			@ApiResponse(responseCode = "500", description = "Internal Server Error"),
			@ApiResponse(responseCode = "400", description = "Not Found Error") })
	@DeleteMapping("/account/{accountId}/documents/documentId")
	public ResponseEntity<?> softDeleteByAccountId(@PathVariable String accountId,
			@Valid @RequestBody DeleteRequest request) throws Exception {
		logger.info("soft deleting the documents with accountId and documentId : {}{}", accountId,
				request.getDocumentId());
		List<AccountResponse> responseList = accountService.SoftDelete(accountId, request);
		return new ResponseEntity<>(responseList, HttpStatus.OK);

	}

}
