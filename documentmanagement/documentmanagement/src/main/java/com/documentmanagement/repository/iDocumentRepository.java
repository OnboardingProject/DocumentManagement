package com.documentmanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.documentmanagement.entity.Documents;



@Repository
public interface iDocumentRepository extends MongoRepository<Documents,String>{

}
