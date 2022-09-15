package com.documentmanagement.service;



import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.documentmanagement.entity.AccountDocument;
import com.documentmanagement.entity.User;
import com.documentmanagement.exception.CustomException;
import com.documentmanagement.repository.iUserRepository;
import com.documentmanagement.request.UserRequest;
import com.documentmanagement.response.UserResponse;
import com.documentmanagement.utils.docStatus;



/**
*
* user service class created by Ann- 212040
*
*/
@Service
public class UserService {



   @Autowired
    iUserRepository userRepository;
    @Autowired
    ModelMapper mapper;
    
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);



   /**
     * update account document status
     *
     * @param userRequest
     * @return userResponse
     * @throws Exception
     */
    public UserResponse updateStatus(UserRequest userRequest) throws Exception {
        List<UserResponse> responseList = new ArrayList<UserResponse>();
        UserResponse userResponse = new UserResponse();
        logger.info("Inside findByUserId :{}", userRequest.getUserId());
        try {
            Optional<User> user = userRepository.findByUserId(userRequest.getUserId());
            if (user.isPresent()) {
                User users = user.get();
                List<AccountDocument> documentList = users.getAccountDocuments();
                boolean documentFlag = false;
                if (!documentList.isEmpty()) {
                    for (AccountDocument document : documentList) {
                        logger.info(document.getDocumentId() + "-------------" + userRequest.getDocumentId());
                        if (document.getDocumentId().equalsIgnoreCase(userRequest.getDocumentId())) {
                            documentFlag = true;
                            if (document.getDocumentStatus().equals(userRequest.getDocumentStatus())) {
                                throw new CustomException("Status already updated");
                            }
                            document.setDocumentStatus(userRequest.getDocumentStatus());
                            mapper.map(document, userResponse);
                            userResponse.setUserId(userRequest.getUserId());
                        }
                        responseList.add(userResponse);
                        mapper.map(responseList, userResponse);
                    }
                }
                if (!documentFlag) {
                    throw new CustomException("No such document found for given userId");
                }
                userRepository.save(users);
            } else {
                throw new CustomException("userId not found");
            }
        } catch (Exception e) {
            logger.error("Exception while callng findByUserId:{}", e);
            throw e;
        }
        return userResponse;
    }

   


    /**
     * user data along with account document data entered statically
     *
     * @return
     */
    public List<User> viewInfo() {
        logger.info("Inside viewInfo method");
        List<AccountDocument> accountDocument = new ArrayList<AccountDocument>();
        AccountDocument doc1 = new AccountDocument("D01", docStatus.disagree);
        AccountDocument doc2 = new AccountDocument("D02", docStatus.disagree);
        AccountDocument doc3 = new AccountDocument("D03", docStatus.disagree);
        accountDocument.add(doc1);
        accountDocument.add(doc2);
        accountDocument.add(doc3);
        User user1 = new User("U01", "AnnJenson", "Walmart", "Ann", "Jenson", "annjenson@email.com", "12334567890",
                "developer", LocalDateTime.now(), "U01-AnnJenson", LocalDateTime.now(), "U01-AnnJenson", "USR01",
                accountDocument);
        userRepository.save(user1);
        logger.info("Fetching the user data along with account documents");
        return userRepository.findAll();



   }



}