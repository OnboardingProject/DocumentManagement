package com.documentmanagement.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data 
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="account")
public class Account implements Serializable{
	/**
	 * Account entity class created by Merin for storing account details 
	 */
	private static final long serialVersionUID=1;
	@Id
	private String accountId;
	private String customerName;
	private String aboutCustomer;
	private String createdDate;
	private String createdBy;
	private String updatedDate;
	private String updatedBy;
	private String accountOverview;
	private List<Documents> documents=new ArrayList<Documents>();
	

 
}
