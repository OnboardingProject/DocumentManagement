package com.documentmanagement.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Document class created for storing the document details
 * @author 212017
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="document")
//@Validated
public class Documents implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private String documentId;
	private String documentName;
	private String documentDesc;
	private String documentSeq;
	private String documentStatus;
	
	
/*
	public Documents() {
		super();

	}

	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getDocumentDesc() {
		return documentDesc;
	}

	public void setDocumentDesc(String documentDesc) {
		this.documentDesc = documentDesc;
	}

	public String getDocumentSeq() {
		return documentSeq;
	}

	public void setDocumentSeq(String documentSeq) {
		this.documentSeq = documentSeq;
	}

	public String getDocumentStatus() {
		return documentStatus;
	}

	public void setDocumentStatus(String documentStatus) {
		this.documentStatus = documentStatus;
	}

	

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public Documents(String documentId, String documentName, String documentDesc, String documentSeq,
			String documentStatus, LocalDateTime createdDate) {
		super();
		this.documentId = documentId;
		this.documentName = documentName;
		this.documentDesc = documentDesc;
		this.documentSeq = documentSeq;
		this.documentStatus = documentStatus;
		this.createdDate = createdDate;
	}*/
	

	
}
