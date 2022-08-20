package com.documentmanagement.controller;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.documentmanagement.exception.CustomException;
import com.documentmanagement.service.FileDownloadService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class FileDownloadController {
	@Autowired
	private FileDownloadService downloadService;

	private static final Logger logger = LoggerFactory.getLogger(FileDownloadController.class);
 
	/**
	 * Method to download file.
	 * 
	 * @param accountId
	 * @param documentName
	 * @return resource
	 * @throws IOException
	 */ 
	@Operation(summary = "download file from accountId ", description = "download file", tags = "DocumentAPI")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "downloaded file"),
			@ApiResponse(responseCode = "500", description = "Internal Server Error") })

	@GetMapping("downloadfile/{accountid}/{documentname}")
	public ResponseEntity<?> downloadFile(@RequestParam("accountId") String accountId,
			@RequestParam("documentName") String documentName) throws IOException {
		Resource resource = null;
		logger.info("Fetching the file by account Id :{} and document name :{}", accountId, documentName);
		resource = downloadService.getFileAsResource(accountId, documentName);
		String contentType = "appication/octet-stream";
		String headerValue = "attachment;filename=\"" + resource.getFilename() + "\"";
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, headerValue).body(resource);

	}

}