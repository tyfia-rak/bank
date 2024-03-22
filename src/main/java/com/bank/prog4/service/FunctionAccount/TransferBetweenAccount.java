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

        Account senderAccount = accountDAO.selectById(transferMoney.getDEBIT_ACCOUNT());
        Account debitAccount = accountDAO.selectById(transferMoney.getCredit_account());


        if ("credit".equals(transferMoney.getType())) {
            Double amount = senderAccount.getBank_balance() - transferMoney.getAmount();
            if (amount < 0) {
                return "insufficient balance";
            } else {
                senderAccount.setBank_balance(amount);
                debitAccount.setBank_balance(debitAccount.getBank_balance() + transferMoney.getAmount());
                accountDAO.save(senderAccount);
                accountDAO.save(debitAccount);
                transferMoneyDAO.save(transferMoney);
                return "credit";
            }
        } else if ("debit".equals(transferMoney.getType())) {
            if (isSamBank(senderAccount, debitAccount)) {

                senderAccount.setBank_balance(senderAccount.getBank_balance() - transferMoney.getAmount());
                accountDAO.save(senderAccount);
            } else {
                return "Wait 48 hours";

            }
            transferMoneyDAO.save(transferMoney);
            return "debit";
        }
        return "success";
    }
    public boolean isSamBank (Account senderAccount, Account debitAccount){
        return senderAccount.getBank_name().equals(debitAccount.getBank_name());
    }

    public static void main(String[] args) throws SQLException {
        Date date = Date.valueOf("2024-12-12");
        Date date1 = Date.valueOf("2024-12-11");

        Transfer_money transferMoney = new Transfer_money(3,5,2500.00,"no reason","credit",date,date1);

        TransferBetweenAccount transferBetweenAccount = new TransferBetweenAccount();
        System.out.println(transferBetweenAccount.TransferAccount(transferMoney));

    }
}
