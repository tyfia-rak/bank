package com.bank.prog4.Generic;

import com.bank.prog4.entity.Account;

import java.sql.SQLException;

public interface GenericDAO<A> {
    A save (A toSave) throws SQLException;

}
