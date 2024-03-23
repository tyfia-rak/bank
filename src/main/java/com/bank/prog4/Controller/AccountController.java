package com.bank.prog4.Controller;

import com.bank.prog4.entity.Account;
import com.bank.prog4.entity.Details;
import com.bank.prog4.entity.Other_bank;
import com.bank.prog4.service.AccountService;
import com.bank.prog4.service.FunctionAccount.IncomingTransferExternalBank;
import com.bank.prog4.service.FunctionAccount.ShowAccountDetails;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin("*")
@RestController
public class AccountController {
    public AccountService accountService;
    public ShowAccountDetails showAccountDetails;
    public IncomingTransferExternalBank incomingTransferExternalBank;

    @GetMapping("/ping")
    public String test (){
        return "pong";
    }
    public AccountController(AccountService accountService,ShowAccountDetails showAccountDetails,IncomingTransferExternalBank incomingTransferExternalBank){
        this.accountService = accountService;
        this.showAccountDetails = showAccountDetails;
        this.incomingTransferExternalBank = incomingTransferExternalBank;
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
    @GetMapping("/details/{id}")
    public Details getDetail(@PathVariable int id)throws SQLException{
        return showAccountDetails.getAccount(id);
    }
    @PostMapping("/other_bank")
    public String inComingMoney(@RequestBody Other_bank otherBank)throws SQLException{
        return incomingTransferExternalBank.IncomingMoney(otherBank);
    }

}
