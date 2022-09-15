package com.documentmanagement.request;



import java.io.Serializable;



import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



import com.documentmanagement.utils.docStatus;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



/**
*
* user request class created by Ann- 212040
*
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotEmpty(message = "User id is mandatory !!")
    private String userId;
    @NotEmpty(message = "Document id is mandatory!!")
    private String documentId;
    private docStatus documentStatus;
    



   
}