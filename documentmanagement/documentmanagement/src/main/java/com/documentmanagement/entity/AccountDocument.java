package com.documentmanagement.entity;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.documentmanagement.request.UserRequest;
import com.documentmanagement.utils.docStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Document(collection = "accountdocuments")
public class AccountDocument {
	@Id
	private String documentId;
	private docStatus documentStatus;
	

}
