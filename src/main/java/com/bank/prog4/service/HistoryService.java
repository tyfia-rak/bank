package com.bank.prog4.service;

import com.bank.prog4.DAO.RetreatHistoryDAO;
import com.bank.prog4.entity.RetreatHistory;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class HistoryService {
    private RetreatHistoryDAO retreatHistoryDAO;

    public HistoryService (RetreatHistoryDAO retreatHistoryDAO){
        this.retreatHistoryDAO = retreatHistoryDAO;
    }
    public List<RetreatHistory> AllHistory() throws SQLException {
        return retreatHistoryDAO.findAll();
    }
}
