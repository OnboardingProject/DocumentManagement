package com.documentmanagement.service;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.documentmanagement.controller.FileUploadController;
import com.documentmanagement.response.FileUploadResponse;

@Service
public class FileUploadService {
	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	
   @Value("${file.upload-dir}")
	private static String basePath;
	public static FileUploadResponse storeFile(String accountId,MultipartFile multipartFile)throws IOException
	{
		try 
		{ 
		//	final String basePath = "C:\\Document-Management\\";
			String fileName=StringUtils.cleanPath(multipartFile.getOriginalFilename());
			logger.info("Creating new folder with accountId"+accountId);
			String directoryPath = new StringBuilder(basePath).append("\\").append(accountId).toString();
			final Path path=Paths.get(directoryPath);
			logger.info("Checking whether path is present or not");
			 if (Files.notExists(path)) {
				 logger.info("Target file \"" + directoryPath + "\" will be created.");
		            Files.createDirectories(path);
		        }       
			logger.info("Creating path for writing the file");
		        String filePath = new StringBuilder(basePath).append("\\").append(accountId) 
		        		.append("\\").append(fileName).toString();
		    	logger.info("Path created : "+filePath);
		        File fpath = new File(filePath);
		        fpath.createNewFile(); 
		        FileOutputStream output = new FileOutputStream(fpath);
		        logger.info("writing the file "+fileName +" to the path "+fpath);
		        output.write(multipartFile.getBytes());
		        output.close();
			 
		}
	catch(IOException e)
		{
		throw new IOException("Error saving upload File:"+multipartFile.getOriginalFilename(),e);
		}
		return null;
		
	}

}
