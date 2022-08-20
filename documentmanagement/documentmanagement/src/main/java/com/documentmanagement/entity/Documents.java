package com.documentmanagement.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="document")
public class Documents implements Serializable{
	/**
	 * Document entity class created by Merin for storing documents details
	 */
	private static final long serialVersionUID=1;
	@Id
	private String documentId;
	private String documentName;
	private String documentDesc;
	private String documentSeq;
	private String documentStatus;
	private String lastUpdatedBy;

	
	

} 
