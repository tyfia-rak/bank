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
        Double rest = account.getBankBalance() - retreat.getAmount();
        Double plus = Math.abs(rest);
        Double permit_credit = account.getSalaryAmount()/3;

       if(!account.getOverdraw() && rest<0){
           return "insufficiencies balance";
       }
       if(account.getOverdraw()){
           if(plus>permit_credit){
               return "insufficiencies credit";
           }else {
            account.setBankBalance(account.getBankBalance()-retreat.getAmount());
            accountDAO.save(account);
            retreatDAO.save(retreat);
           }
       }
        account.setBankBalance(account.getBankBalance()-retreat.getAmount());
        accountDAO.save(account);
        retreatDAO.save(retreat);
       return "retreat effectued";
    }

public static void main(String[] args) throws SQLException {
        Date date = Date.valueOf("2018-12-15");
      Retreat retreat = new Retreat(15000.00,date,3);
      RetreatAccount retreatAccount = new RetreatAccount();
        System.out.println(retreatAccount.withdrawMoney(retreat));

    }



}