package com.documentmanagement.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * Accounts entity class created by Ann- 212040
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="accounts")
public class Accounts implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String accountId;
	private String customerName;
	private String customerDesc;
	private LocalDateTime createdOn;
	private String createdBy;
	private LocalDateTime updatedOn;
	private String updatedBy;
	private String accountOverview;

	/*private List<documents> documents = new ArrayList<documents>();
	private List<initiatives> initiatives = new ArrayList<initiatives>();
	private List<engagements> engagements = new ArrayList<engagements>();
*/
	

	
}
