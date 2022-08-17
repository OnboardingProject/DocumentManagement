package com.documentmanagement.request;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class DocumentRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	@NotEmpty(message = "documentId is mandatory to fill !!")
	private String documentId;
	@NotEmpty(message = "documentName is mandatory to fill !!")
	private String documentName;
	@NotEmpty(message = "documentDesc is mandatory to fill !!")
	private String documentDesc;
	@NotEmpty(message = "documentSeq is mandatory to fill !!")
	private String documentSeq;
	@NotEmpty(message = "documentStatus is mandatory to fill !!")
	private String documentStatus;

}
