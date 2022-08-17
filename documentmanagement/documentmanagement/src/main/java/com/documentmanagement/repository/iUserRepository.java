package com.documentmanagement.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.documentmanagement.entity.User;

/**
 * 
 * user repository interface created by Ann- 212040
 *
 */
public interface iUserRepository extends MongoRepository<User,String> {

	public Optional<User> findByUserId(String userId);



}
