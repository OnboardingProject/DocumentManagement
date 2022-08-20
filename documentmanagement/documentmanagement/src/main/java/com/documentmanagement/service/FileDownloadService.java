package com.documentmanagement.service;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import com.documentmanagement.exception.CustomException;

@Service
public class FileDownloadService {
	private static final Logger logger = LoggerFactory.getLogger(FileDownloadService.class);
	
	@Value("${file.upload-dir}")
    private String basePath;
	
	/** 
	 * Method to download file
	 * 
	 * @param accountId
	 * @param documentName
	 * @return UrlResource
	 * @throws IOException
	 */ 
	
	public Resource getFileAsResource(String accountId, String documentName) throws IOException {
  
		try {  
			String regex = "[a-zA-Z0-9_/-]+.+[a-zA-Z]$";

			if (documentName.contains(".") && documentName.matches(regex)) {
				logger.info("Checking whether document name is in correct format :{}", documentName);
			//	final String basePath = "C:\\Document-Management\\";
				String directoryPath = new StringBuilder(basePath).append("\\").append(accountId).append("\\")
						.append(documentName).toString();
				logger.info("Path to download the file :{}", directoryPath);
 
				final Path path = Paths.get(directoryPath);
 
				logger.info("Checking whether path is present or not");
				if (Files.notExists(path)) {
					logger.info("Exception thrown while path is not found");
					throw new CustomException("File not found");
				} else {
					logger.info("Returning the UrlResource since the file is found");
				System.out.println(path.toUri());
					return new UrlResource(path.toUri());

				} 
			} else {
				logger.info("Exception while file name is in incorrect format");
				throw new CustomException("Incorrect file format");
			}
		}

		catch (IOException e) {
			logger.info("Exception while error in downlading file");
			throw new IOException("Error while downloading file", e);
		}
	}




}
