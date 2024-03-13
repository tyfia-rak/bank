package com.bank.prog4.service;

import com.bank.prog4.DAO.AccountDAO;
import com.bank.prog4.entity.Account;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class AccountService {
    private AccountDAO accountDAO;
    public AccountService (AccountDAO accountDAO){
        this.accountDAO = accountDAO;
    }
    public Account insert (Account toInsert) throws SQLException{
        accountDAO.save(toInsert);
        return toInsert;
    }
}
