package com.bank.prog4.Controller;

import com.bank.prog4.entity.Account;
import com.bank.prog4.entity.Details;
import com.bank.prog4.entity.Other_bank;
import com.bank.prog4.entity.Transfer_money;
import com.bank.prog4.service.AccountService;
import com.bank.prog4.service.FunctionAccount.IncomingTransferExternalBank;
import com.bank.prog4.service.FunctionAccount.ShowAccountDetails;
import com.bank.prog4.service.FunctionAccount.TransferBetweenAccount;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin("*")
@RestController
public class AccountController {
    public AccountService accountService;
    public ShowAccountDetails showAccountDetails;
    public IncomingTransferExternalBank incomingTransferExternalBank;
    public TransferBetweenAccount transferBetweenAccount;

    @GetMapping("/ping")
    public String test (){
        return "pong";
    }
    public AccountController(AccountService accountService,ShowAccountDetails showAccountDetails,IncomingTransferExternalBank incomingTransferExternalBank, TransferBetweenAccount transferBetweenAccount){
        this.accountService = accountService;
        this.showAccountDetails = showAccountDetails;
        this.incomingTransferExternalBank = incomingTransferExternalBank;
        this.transferBetweenAccount = transferBetweenAccount;
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
    @PostMapping("/Transfer_account")
    public String TransferBetweenAccount(@RequestBody Transfer_money transferMoney)throws SQLException{
        return transferBetweenAccount.TransferAccount(transferMoney);
    }

}
