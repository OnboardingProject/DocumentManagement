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
	
	private List<Documents> documentList = new ArrayList<Documents>();

	

}
