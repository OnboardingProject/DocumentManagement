package com.documentmanagement.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import com.documentmanagement.utils.DocumentStatus;

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
	private DocumentStatus documentStatus;
	

	

	
}
