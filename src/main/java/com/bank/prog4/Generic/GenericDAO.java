package com.bank.prog4.Generic;

import com.bank.prog4.entity.Account;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface GenericDAO<A> {
    A save (A toSave) throws SQLException;
    A selectById(int id) throws SQLException;
    List<A> findAll() throws SQLException;
    A update (A update) throws SQLException;
}
