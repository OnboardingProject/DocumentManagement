package com.documentmanagement.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author 211458
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponse {
	private String documentId;
	private String documentName;
	private String documentDesc;
	private String documentSeq;
	private String documentStatus;

}
