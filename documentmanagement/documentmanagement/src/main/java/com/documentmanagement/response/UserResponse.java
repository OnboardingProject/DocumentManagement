package com.documentmanagement.response;

import com.documentmanagement.utils.docStatus;

import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * user response class created by Ann- 212040
 *
 */
@Data
@NoArgsConstructor
public class UserResponse  {
	private String userId;
	private String documentId;
	private docStatus documentStatus;
	
	
	
}