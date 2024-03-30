package com.bank.prog4.service;

import com.bank.prog4.DAO.RetreatDAO;
import com.bank.prog4.entity.Retreat;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class RetreatService {
    private RetreatDAO retreatDAO;
    public RetreatService (RetreatDAO retreatDAO){
        this.retreatDAO=retreatDAO;
    }
    public List<Retreat> findAll() throws SQLException{
        return retreatDAO.findAll();
    }
}
