package com.bank.prog4.service.FunctionAccount;

import com.bank.prog4.DAO.AccountDAO;
import com.bank.prog4.DAO.Other_bankDAO;
import com.bank.prog4.entity.Account;
import com.bank.prog4.entity.Other_bank;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.SQLException;

@Service
public class IncomingTransferExternalBank {
    public String IncomingMoney (Other_bank otherBank) throws SQLException {
        AccountDAO accountDAO = new AccountDAO();
        Other_bankDAO otherBankDAO = new Other_bankDAO();
        Account account = accountDAO.selectById(otherBank.getId_account());
        double more = account.getBank_balance()+otherBank.getAmount();
        account.setBank_balance(more);
        accountDAO.save(account);
        otherBankDAO.save(otherBank);
        return "Transaction effectued";
    }

    public static void main(String[] args) throws SQLException {
        Date date = Date.valueOf("2024-12-12");
        Date dater = Date.valueOf("2024-12-11");
        Other_bank otherBank = new Other_bank(1,3000.00,"OOO","NO REASON",date,dater,1);
        IncomingTransferExternalBank incomingTransferExternalBank = new IncomingTransferExternalBank();
        System.out.println(incomingTransferExternalBank.IncomingMoney(otherBank));
    }
}
