package com.bank.prog4.Controller;

import com.bank.prog4.entity.Retreat;
import com.bank.prog4.entity.RetreatHistory;
import com.bank.prog4.service.HistoryService;
import com.bank.prog4.service.RetreatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class HistoryRetreatController {
    private HistoryService historyService;

    public HistoryRetreatController (HistoryService historyService){
        this.historyService =historyService;
    }
    @GetMapping("/history_retreat")
    public List<RetreatHistory> findHistory() throws SQLException {
        return historyService.AllHistory();
    }
}
