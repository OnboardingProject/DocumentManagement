/*package com.documentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.documentmanagement.entity.Account;
import com.documentmanagement.service.AccountService;
@RestController
public class AccountController {
	@Autowired
	private AccountService accountService;
	@GetMapping("/accounts")
    public List<Account> getAllAccount()
    {
        //logger.info("Geting all account details ");
        return accountService.viewInfo();
        
    }

}
*/