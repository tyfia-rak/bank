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

        if(!isSamBank(senderAccount,debitAccount)){
            return "wait 48 hours";
        }
        else {
            if(isSamBank(senderAccount, debitAccount)){
                senderAccount.setBankBalance(amount);
                debitAccount.setBankBalance(debitAccount.getBankBalance() + transferMoney.getAmount());
                accountDAO.save(senderAccount);
                accountDAO.save(debitAccount);
                transferMoneyDAO.save(transferMoney);
                return "credit";
            }else {
                return "Wait 48 hours";
            }
        }

    }

    public boolean isSamBank (Account senderAccount, Account debitAccount){
        return senderAccount.getBankName().equals(debitAccount.getBankName());
    }
}
/*
            }if (isSamBank(senderAccount, debitAccount)) {

                senderAccount.setBankBalance(senderAccount.getBankBalance() - transferMoney.getAmount());
                accountDAO.save(senderAccount);
            } else {
                return "Wait 48 hours";

            }
          */

 /*
     public static void main(String[] args) throws SQLException {
        Date date = Date.valueOf("2024-12-12");
        Date date1 = Date.valueOf("2024-12-11");

        Transfer_money transferMoney = new Transfer_money(3,5,2500.00,"no reason","credit",date,date1);

        TransferBetweenAccount transferBetweenAccount = new TransferBetweenAccount();
        System.out.println(transferBetweenAccount.TransferAccount(transferMoney));



    }
     */