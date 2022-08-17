package com.documentmanagement.entity;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * Account entity class is created by Swathi for storing account details
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor


@Document(collection="account")
@Validated
public class Account implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private String accountId;
	private String customerName;
	private String aboutCustomer;
	private LocalDateTime createdDate;
	private String createdBy;
	private LocalDateTime updatedDate;
	private String updatedBy;
	private String accountOverview;
	
	private List<Documents> documents = new ArrayList<Documents>();
	/*public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAboutCustomer() {
		return aboutCustomer;
	}
	public void setAboutCustomer(String aboutCustomer) {
		this.aboutCustomer = aboutCustomer;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getAccountOverview() {
		return accountOverview;
	}
	public void setAccountOverview(String accountOverview) {
		this.accountOverview = accountOverview;
	}

	public List<Documents> getDocuments() {
		return documents;
	}
	public void setDocuments(List<Documents> documents) {
		this.documents = documents;
	}
	public Account(String accountId, String customerName, String aboutCustomer, LocalDateTime createdDate,
			String createdBy, LocalDateTime updatedDate, String updatedBy, String accountOverview,
			 List<Documents> documents) {
		super();
		this.accountId = accountId;
		this.customerName = customerName;
		this.aboutCustomer = aboutCustomer;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
		this.accountOverview = accountOverview;
		
		this.documents = documents;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	*/
	

}
