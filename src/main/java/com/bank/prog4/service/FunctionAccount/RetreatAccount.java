package com.bank.prog4.service.FunctionAccount;

import com.bank.prog4.DAO.AccountDAO;
import com.bank.prog4.DAO.RetreatDAO;
import com.bank.prog4.entity.Account;
import com.bank.prog4.entity.Retreat;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.sql.SQLException;

@Service
public class RetreatAccount {
    public String withdrawMoney(Retreat retreat) throws SQLException {
        AccountDAO accountDAO = new AccountDAO();
        RetreatDAO retreatDAO = new RetreatDAO();
        Account account = accountDAO.selectById(retreat.getId_account());
        Double rest = account.getBank_balance() - retreat.getAmount();
        Double plus = Math.abs(rest);
        Double permit_credit = account.getSalary_amount()/3;

        if(!account.getOverdraw() && rest<0){
            return "insufficient balance";
        }

        else {
            if(plus>permit_credit){
                return "Violation credit";
            }
            account.setBank_balance(rest);
            accountDAO.save(account);
            retreatDAO.save(retreat);
            return "Retreat effectued";
        }

    }
/*
public static void main(String[] args) throws SQLException {
        Date date = Date.valueOf("2018-12-15");
      Retreat retreat = new Retreat(1,12000.00,date,0);
      RetreatAccount retreatAccount = new RetreatAccount();
        System.out.println(retreatAccount.withdrawMoney(retreat));

    }
 */

}