package com.documentmanagement.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.documentmanagement.entity.Account;
import com.documentmanagement.request.DocumentRequest;
/**
 * 
 * AccountRepository is created by swathi-@author 212017
 *
 */
@Repository
public interface iAccountRepository extends MongoRepository<Account, String>{

	Optional<Account> findByAccountId(String accountId);

	

	

}
