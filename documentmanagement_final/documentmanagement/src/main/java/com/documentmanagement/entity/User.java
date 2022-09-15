package com.documentmanagement.entity;



import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="user")
/**
*
* user entity class created by Ann- 212040
*
*/



public class User implements Serializable {



   private static final long serialVersionUID = 1L;
    @Id
    private String userId;
    private String userName;
    private String accountName;
    private String firstName;
    private String lastName;
    private String emailId;
    private String phoneNo;
    private String designation;
    private LocalDateTime createdOn;
    private String createdBy;
    private LocalDateTime lastUpdatedOn;
    private String lastUpdatedBy;
    private String roleId;
    private List<AccountDocument> accountDocuments = new ArrayList<AccountDocument>();



   
}