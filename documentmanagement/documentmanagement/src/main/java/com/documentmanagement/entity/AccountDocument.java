package com.documentmanagement.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.documentmanagement.utils.docStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * 
 * account document class created by Ann- 212040
 *
 */
@Document(collection = "accountdocuments")
public class AccountDocument {
	@Id
	private String documentId;
	private docStatus documentStatus;
	

}
