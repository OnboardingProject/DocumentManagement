package com.documentmanagement.controller;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.documentmanagement.response.FileUploadResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class FileUploadController {

	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

	@Operation(summary = "Upload document to an accountId ", description = "Upload file", tags = "DocumentAPI")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Upload file"),
			@ApiResponse(responseCode = "500", description = "Internal Server Error") })

	@PostMapping(value="/upload",consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<FileUploadResponse> uploadFile1(@RequestParam("accountId") String accountId,
			@RequestParam("file") MultipartFile multipartFile) throws IOException {
		FileUploadResponse response = new FileUploadResponse();
		try {
			final String basePath = "C:\\Document-Management\\";
			String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
			logger.info("Creating new folder with accountId" + accountId);

			String directoryPath = new StringBuilder(basePath).append("\\").append(accountId).toString();
			final Path path = Paths.get(directoryPath);
			logger.info("Checking whether path is present or not");
			if (Files.notExists(path)) {
				logger.info("Target file \"" + directoryPath + "\" will be created.");
				Files.createDirectories(path);
			}
			logger.info("Creating path for writing the file");
			String filePath = new StringBuilder(basePath).append("\\").append(accountId).append("\\").append(fileName)
					.toString();
			logger.info("Path created : " + filePath);
			File fpath = new File(filePath);
			fpath.createNewFile();
			FileOutputStream output = new FileOutputStream(fpath);
			logger.info("writing the file " + fileName + " to the path " + fpath);
			output.write(multipartFile.getBytes());
			output.close();

			response.setFileName(fileName);

		} catch (IOException e) {
			throw new IOException("Error saving upload File:" + multipartFile.getOriginalFilename(), e);
		}

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

}
