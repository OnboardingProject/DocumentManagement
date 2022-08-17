package com.documentmanagement.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.documentmanagement.entity.AccountDocument;
import com.documentmanagement.entity.User;
import com.documentmanagement.exception.CustomException;
import com.documentmanagement.repository.iUserRepository;
import com.documentmanagement.request.UserRequest;
import com.documentmanagement.response.UserResponse;
import com.documentmanagement.utils.docStatus;

/**
 * 
 * user service class created by Ann- 212040
 *
 */
@Service
public class UserService {

	@Autowired
	iUserRepository userRepository;

	private ModelMapper mapper = new ModelMapper();
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	/**
	 * user data along with account document data entered statically
	 * 
	 * @return
	 */
	public List<User> viewInfo() {
		logger.info("Inside viewInfo method");
		List<AccountDocument> accountDocument = new ArrayList<AccountDocument>();
		AccountDocument doc1 = new AccountDocument("D01", docStatus.disagree);
		AccountDocument doc2 = new AccountDocument("D02", docStatus.disagree);
		AccountDocument doc3 = new AccountDocument("D03", docStatus.disagree);
		accountDocument.add(doc1);
		accountDocument.add(doc2);
		accountDocument.add(doc3);
		User user1 = new User("U01", "AnnJenson", "Walmart", "Ann", "Jenson", "annjenson@email.com",
				"12334567890", "developer", LocalDateTime.now(), "U01-AnnJenson", LocalDateTime.now(),
				"U01-AnnJenson", "USR01", accountDocument);
		userRepository.save(user1);
		logger.info("Fetching the user data along with account documents");
		return userRepository.findAll();

	}

	/**
	 * update the account documentStatus
	 * 
	 * @param userRequest
	 * @return
	 */
	public UserResponse updateStatus(UserRequest userRequest) throws Exception {
		List<UserResponse> responseList = new ArrayList<UserResponse>();
		UserResponse userResponse = new UserResponse();
		logger.info("Inside findByUserId :{}", userRequest.getUserId());
		try {
			Optional<User> user = userRepository.findByUserId(userRequest.getUserId());
			if (user.isPresent()) {
				User users = user.get();
				List<AccountDocument> documentList = users.getAccountDocuments();
				if (!documentList.isEmpty()) {
					logger.info("Checking document list is present or not for :{}", userRequest.getUserId());
					List<AccountDocument> documents = documentList.stream()
							.filter(docId -> docId.getDocumentId().equals(userRequest.getDocumentId()))
							.collect(Collectors.toList());
					logger.info("Document list :{} ",documents);
					if (documents.isEmpty()) {
						throw new CustomException("No such document found for given userId");
					}
				else
				{
					for (AccountDocument document : documents) {
						if (document.getDocumentId().equalsIgnoreCase(userRequest.getDocumentId())) {
						logger.info("Setting document status for : {}",userRequest.getUserId());
							mapper.map(document, userResponse);
							userResponse.setUserId(userRequest.getUserId());
							userResponse.setDocumentStatus(userRequest.getDocumentStatus());
							responseList.add(userResponse);
							mapper.map(responseList, userResponse);
						}
					}
				}
				}
				userRepository.save(users);
			} else {
				throw new CustomException("userId not found");
			}
		} catch (Exception e) {
			logger.error("Exception while callng findByUserId:{}", e);
			throw e;
		}
		return userResponse;
	}

	/**
	 * delete duplicate values if any
	 * 
	 * @return
	 *//*
	public List<User> deleteInfo() {
		logger.info("Inside deleteInfo method ");
		userRepository.deleteAll();
		return userRepository.findAll();
	}*/

}
