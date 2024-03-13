package com.bank.prog4.Controller;

import com.bank.prog4.entity.Account;
import com.bank.prog4.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class AccountController {
    public AccountService accountService;
    @GetMapping("/ping")
    public String test (){
        return "pong";
    }
    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }
    public Account insertAccount(@RequestBody Account toInsert) throws SQLException{
        return  accountService.insert(toInsert);
    }
}
