package com.documentmanagement.request;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * document request class created by swathi -@author 212017
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class DocumentRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	@NotEmpty(message = "documentId is mandatory ")
	private String documentId;
	/*@NotEmpty(message = "documentName is mandatory ")
	private String documentName;*/
	@NotEmpty(message = "documentDesc is mandatory ")
	private String documentDesc;
	@NotEmpty(message = "documentSeq is mandatory ")
	private String documentSeq;
	@NotEmpty(message = "documentStatus is mandatory ")
	private String documentStatus;

}
