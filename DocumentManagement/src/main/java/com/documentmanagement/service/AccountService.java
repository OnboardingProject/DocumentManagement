package com.documentmanagement.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.documentmanagement.controller.AccountController;
import com.documentmanagement.entity.Account;
import com.documentmanagement.entity.Documents;
import com.documentmanagement.exception.CustomException;
import com.documentmanagement.repository.iAccountRepository;

import com.documentmanagement.request.DocumentRequest;
import com.documentmanagement.response.FileUploadResponse;

/**
 * 
 * Account Service class created by swathi
 *
 */
@Service
public class AccountService {
	@Autowired
	iAccountRepository accountRepository;
	
	@Autowired
	private ModelMapper mapper;
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

	/**
	 * 
	 * @return
	 */
	public List<Account> insertAccount() {
		List<Documents> accountDocument = new ArrayList<Documents>();
		Documents doc1 = new Documents("D01", "Document1", "Document 1", "seq", "Agree");
		Documents doc2 = new Documents("D02", "Document2", "Document 1", "seq", "Agree");
		accountDocument.add(doc1);
		accountDocument.add(doc2);
		Account account1 = new Account("A01", "swathi", "customer 1", LocalDateTime.now(), "test", LocalDateTime.now(),
				"Ann Maria", "Overview", accountDocument);
		logger.info("Saving the Account details into the repository");
		accountRepository.save(account1);
		return accountRepository.findAll();

	}

	@Value("${file.upload-dir}")
	private String basePath;

	/**
	 * 
	 * @param accountId
	 * @param multipartFile
	 * @param doc
	 * @return
	 * @throws IOException
	 */
	public FileUploadResponse uploadFile(String accountId, MultipartFile multipartFile, DocumentRequest doc)
			throws IOException {

		FileUploadResponse response = new FileUploadResponse();

		try {

			Optional<Account> accounts = accountRepository.findById(accountId);
			if (accounts.isPresent()) {
				String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
				logger.info("Creating new folder with accountId:{}" , accountId);

				String directoryPath = new StringBuilder(basePath).append("\\").append(accountId).toString();
				final Path path = Paths.get(directoryPath);
				logger.info("Checking whether path is present or not");
				if (Files.notExists(path)) {
					logger.info("Target file path is e created:{}",  directoryPath );
					Files.createDirectories(path);
				}
				logger.info("Creating path for writing the file");
				String filePath = new StringBuilder(basePath).append("\\").append(accountId).append("\\")
						.append(fileName).toString();
				logger.info("Path created : " + filePath);
				File fpath = new File(filePath);
				fpath.createNewFile();
				FileOutputStream output = new FileOutputStream(fpath);
				logger.info("writing the file to the path:{}", fpath);
				output.write(multipartFile.getBytes());
				output.close();

				Account account = accounts.get();
				List<Documents> documentList = account.getDocuments();
				Documents documents = new Documents();
				doc.setDocumentName(fileName);
				mapper.map(doc, documents);
				documentList.add(documents);
				account.setDocuments(documentList);
				accountRepository.save(account);
				logger.info("Account entity is updated with document details");
				response.setFileName(fileName);
				response.setDocumentId(doc.getDocumentId());
				response.setDocumentStatus(doc.getDocumentStatus());
				response.setDocumentSeq(doc.getDocumentSeq());
				response.setDocumentDesc(doc.getDocumentDesc());
				response.setErrorMsg("Success");
				/* System.out.println(doc); */

			} else {
				throw new CustomException("Invalid AccountId ");
			}

		} catch (IOException e) {
			throw new IOException("Error saving upload File:" + multipartFile.getOriginalFilename(), e);

		}
		return response;

	}

	/**
	 * 
	 * @return
	 */
	public <T> List<Account> getUserInfo() {

		return accountRepository.findAll();
	}

}
