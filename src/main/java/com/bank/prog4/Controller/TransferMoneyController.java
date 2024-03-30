package com.bank.prog4.Controller;

import com.bank.prog4.entity.Transfer_money;
import com.bank.prog4.service.TranferMoneyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class TransferMoneyController {
    private TranferMoneyService tranferMoneyService;
    public TransferMoneyController (TranferMoneyService tranferMoneyService){
        this.tranferMoneyService = tranferMoneyService;
    }
    @GetMapping("/all_transferMoney")
    public List<Transfer_money> AllRetreat ()throws SQLException{
        return tranferMoneyService.findAll();
    }
}
