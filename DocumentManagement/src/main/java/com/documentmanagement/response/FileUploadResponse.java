package com.documentmanagement.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileUploadResponse implements Serializable {
	private static final long serialVersionUID = 1L; 
public String fileName;
private String documentId;
private String documentDesc;
private String documentSeq;
private String documentStatus;
private String errorMsg;


}
