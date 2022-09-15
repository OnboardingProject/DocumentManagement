package com.documentmanagement.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.documentmanagement.entity.Account;
import com.documentmanagement.entity.Documents;
import com.documentmanagement.exception.CustomException;
import com.documentmanagement.repository.iAccountRepository;
import com.documentmanagement.request.DeleteRequest;
import com.documentmanagement.response.AccountResponse;
import com.documentmanagement.utils.DocumentStatus;

@Service
public class AccountService {
	@Autowired
	private iAccountRepository accountRepository;
	@Autowired
	private ModelMapper mapper;

	private static final Logger logger = LoggerFactory.getLogger(AccountService.class);

	/**
	 * method to get all details
	 *
	 * @return findAll
	 */
	public List<Account> findAll() {

		return accountRepository.findAll();
	}

	/**
	 * method to insert and getting the details
	 *
	 * @return find all
	 */
	public List<Account> viewInfo() {
		List<Documents> documentList = new ArrayList<Documents>();
		Documents document1 = new Documents("1", "name1", "first document", "documentseq", DocumentStatus.ACTIVE);
		Documents document2 = new Documents("2", "name2", "second document", "documentseq", DocumentStatus.ACTIVE);
		Documents document3 = new Documents("3", "name3", "third document", "documentseq", DocumentStatus.ACTIVE);
		Documents document4 = new Documents("4", "name4", "fourth document", "documentseq", DocumentStatus.ACTIVE);
		documentList.add(document1);
		documentList.add(document2);
		documentList.add(document3);
		documentList.add(document4);
		Account account1 = new Account("1", "customer1", null, LocalDateTime.now(), null, LocalDateTime.now(), null,
				null, documentList);
		Account account2 = new Account("2", "customer2", null, LocalDateTime.now(), null, LocalDateTime.now(), null,
				null, null);
		
		accountRepository.save(account1);
		accountRepository.save(account2);
		return accountRepository.findAll();
	}

	/**
	 * method to find documents by accountId
	 *
	 * @param accountId
	 * @return responseList
	 * @throws Exception
	 */
	public List<AccountResponse> getDocumentsByAccountId(String accountId) throws Exception {
		List<AccountResponse> responseList = new ArrayList<AccountResponse>();
		logger.info("inside findByAccountId :{}", accountId);
		try {
			Optional<Account> accounts = accountRepository.findByAccountId(accountId);
			if (accounts.isPresent()) {
				logger.info("checking accountId is present or not :{}", accounts);
				Account account = accounts.get();
				logger.info("getting the account details by accountId :{}", accountId);
				List<Documents> documents = account.getDocumentList();
				logger.info("getting the document list :{}", account.getDocumentList());
				if (!documents.isEmpty()) {
					logger.info("checking the document list is empty or not :{}", documents);
					for (Documents document : documents) {
						AccountResponse response = new AccountResponse();
						mapper.map(document, response);
						responseList.add(response);
					}
				}

			} else {
				throw new CustomException("accountId not found");
			}
		} catch (Exception e) {
			logger.error("Exception while calling findByAccountId :{}", accountId, e);
			throw e;
		}

		return responseList.stream().filter(docList -> (StringUtils.isNotEmpty(docList.getDocumentStatus())
				&& docList.getDocumentStatus().equalsIgnoreCase("ACTIVE"))).collect(Collectors.toList());
	}
	  /**
     * Method to soft delete the Document
     *
     * @param accountId
     * @param request
     * @return responseList
     */
    public List<AccountResponse> SoftDelete(String accountId, DeleteRequest request) throws Exception {
        List<AccountResponse> responseList = new ArrayList<AccountResponse>();
        logger.info("inside findByAccountId :{}", accountId);
        try {
            Optional<Account> accounts = accountRepository.findByAccountId(accountId);
            if (accounts.isPresent()) {
                logger.info("checking account is present or not :{}", accounts);
                Account account = accounts.get();
                List<Documents> documentList = account.getDocumentList();
                boolean documentFlag = false;
                if (!documentList.isEmpty()) {
                    for (Documents document : documentList) {
                        logger.info(document.getDocumentId() + "-------------" + request.getDocumentId());
                        if (document.getDocumentId().equalsIgnoreCase(request.getDocumentId())) {
                            documentFlag = true;
                            if (document.getDocumentStatus().equals(request.getDocumentStatus())) {
                                throw new CustomException("Operation is already performed");
                            }
                            document.setDocumentStatus(request.getDocumentStatus());
                        }
                        AccountResponse response = new AccountResponse();
                        mapper.map(document, response);
                        responseList.add(response);
                    }
                    if(!documentFlag) {
                        throw new CustomException("document not found");
                    }
                }



               accountRepository.save(account);
            } else {
                throw new CustomException("account not found");
            }



       } catch (Exception e) {
            logger.error("Exception while calling findByAccountId :{}", accountId, e);
            throw e;
        }
        return responseList.stream().filter(docList -> (StringUtils.isNotEmpty(docList.getDocumentStatus())
                && docList.getDocumentStatus().equalsIgnoreCase("ACTIVE"))).collect(Collectors.toList());
    }
}

