package com.bank.prog4.service.FunctionAccount;

import com.bank.prog4.DAO.AccountDAO;
import com.bank.prog4.DAO.TransferMoneyDAO;
import com.bank.prog4.entity.Account;
import com.bank.prog4.entity.Transfer_money;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.SQLException;

@Service
public class TransferBetweenAccount {
    public String TransferAccount(Transfer_money transferMoney) throws SQLException {
        AccountDAO accountDAO = new AccountDAO();
        TransferMoneyDAO transferMoneyDAO = new TransferMoneyDAO();

        Account senderAccount = accountDAO.selectById(transferMoney.getDebit_account());
        Account debitAccount = accountDAO.selectById(transferMoney.getCredit_account());


        Double amount = senderAccount.getBankBalance() - transferMoney.getAmount();
        if (amount < 0) {
            return "insufficient balance";
        }

        if (!isSamBank(senderAccount, debitAccount)) {
            return "wait 48 hours";
        } else {
            if (isSamBank(senderAccount, debitAccount)) {
                senderAccount.setBankBalance(amount);
                debitAccount.setBankBalance(debitAccount.getBankBalance() + transferMoney.getAmount());
                accountDAO.update(debitAccount);
                accountDAO.update(senderAccount);
                transferMoneyDAO.save(transferMoney);
                return "credit";
            } else {
                return "Wait 48 hours";
            }
        }

    }

    public boolean isSamBank(Account senderAccount, Account debitAccount) {
        return senderAccount.getBankName().equals(debitAccount.getBankName());
    }
/*
public static void main(String[] args) throws SQLException {
        Date date = Date.valueOf("2024-12-12");
        Date date1 = Date.valueOf("2024-12-11");

        Transfer_money transferMoney = new Transfer_money(2, 3, 50000, "no reason", date, date1);

        TransferBetweenAccount transferBetweenAccount = new TransferBetweenAccount();
        System.out.println(transferBetweenAccount.TransferAccount(transferMoney));
    }
 */

}
