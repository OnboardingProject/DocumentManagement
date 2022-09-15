package com.documentmanagement.request;



import java.io.Serializable;



import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.documentmanagement.utils.DocumentStatus;

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
public class DeleteRequest implements Serializable {
    private static final long serialVersionUID = 1;
    @NotEmpty(message = "documentId is mandatory")
    @NotNull(message = "documentId is mandatory")
    private String documentId;
    private DocumentStatus documentStatus;;



}