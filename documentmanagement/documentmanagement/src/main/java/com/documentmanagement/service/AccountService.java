/*package com.documentmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.documentmanagement.entity.Account;
import com.documentmanagement.entity.Documents;
import com.documentmanagement.repository.iAccountRepository;
@Service
public class AccountService {
	@Autowired
	private iAccountRepository accountRepo; 
	public List<Account> viewInfo() {
        //logger.info("Inside viewInfo method");
        List<Documents> accountDocument = new ArrayList<Documents>();
        Documents doc1 = new Documents("D01", "Document1", "Document 1", "seq","Agree", "21-04-2022");
        Documents doc2 = new Documents("D02", "Document2", "Document 1", "seq", "Agree","21-04-2022");
        accountDocument.add(doc1);
        accountDocument.add(doc2);
        Account account1 = new Account("A01", "Merin", "customer 1", "21-04-2022", "Swathi", "21-04-2022", "Ann Maria", "Overview", accountDocument);
        //logger.info("Saving the Account details into the repository");
        accountRepo.save(account1);
        return accountRepo.findAll();



   }

}
*/