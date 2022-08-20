package com.documentmanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.documentmanagement.entity.Account;

	@Repository
	public interface iAccountRepository extends MongoRepository<Account,String>{}


