package com.bank.prog4.service;

import com.bank.prog4.DAO.TransferMoneyDAO;
import com.bank.prog4.entity.Transfer_money;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class TranferMoneyService {
    private TransferMoneyDAO transferMoneyDAO;
    public TranferMoneyService (TransferMoneyDAO transferMoneyDAO){
        this.transferMoneyDAO = transferMoneyDAO;
    }
    public List<Transfer_money> findAll() throws SQLException{
        return transferMoneyDAO.findAll();
    }
}
