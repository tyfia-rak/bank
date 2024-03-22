package com.bank.prog4.Controller;

import com.bank.prog4.entity.Account;
import com.bank.prog4.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin("*")
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
    @PostMapping("/insert")
    public Account insertAccount(@RequestBody Account toInsert) throws SQLException{
        return  accountService.insert(toInsert);
    }
    @GetMapping("/id_account/{id}")
    public Account selectClient (@PathVariable int id) throws SQLException{
        return accountService.idAccount(id);
    }
    @GetMapping("/all_account")
    public List<Account> AllAccount ()throws  SQLException{
        return accountService.findAll();
    }
}
