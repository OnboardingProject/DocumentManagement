package com.documentmanagement.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.documentmanagement.utils.docStatus;



/**
 * 
 * Document entity class created by Ann- 212040
 *
 */
@org.springframework.data.mongodb.core.mapping.Document(collection="document")
public class Document implements Serializable {
	private static final long serialVersionUID = 1L;
	private String documentId;
	private String documentName;
	private String documentDesc;
	private String documentSeq;
	private docStatus documentStatus;
	private LocalDateTime lastUpdatedOn;
	private String lastUpdatedBy;
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

	public docStatus getDocumentStatus() {
		return documentStatus;
	}

	public void setDocumentStatus(docStatus documentStatus) {
		this.documentStatus = documentStatus;
	}

	public LocalDateTime getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	public void setLastUpdatedOn(LocalDateTime lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Document(String documentId, String documentName, String documentDesc, String documentSeq,
			docStatus documentStatus, LocalDateTime lastUpdatedOn, String lastUpdatedBy) {
		super();
		this.documentId = documentId;
		this.documentName = documentName;
		this.documentDesc = documentDesc;
		this.documentSeq = documentSeq;
		this.documentStatus = documentStatus;
		this.lastUpdatedOn = lastUpdatedOn;
		this.lastUpdatedBy = lastUpdatedBy;
	}



}
