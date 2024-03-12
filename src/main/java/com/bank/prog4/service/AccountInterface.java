package com.bank.prog4.service;

import com.bank.prog4.entity.Account;

import java.sql.SQLException;
import java.util.List;

public interface AccountInterface {
    void insert(Account toInsert) throws SQLException;

    List<Account> getAll() throws SQLException;

    void update(Account toUpdate) throws SQLException;
}
