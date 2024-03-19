package com.bank.prog4.service;

import com.bank.prog4.DAO.AccountDAO;
import com.bank.prog4.entity.Account;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.sql.SQLException;
import java.util.Optional;

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
    public Account idAccount(int id) throws SQLException{
        return accountDAO.selectById(id);
    }
}
