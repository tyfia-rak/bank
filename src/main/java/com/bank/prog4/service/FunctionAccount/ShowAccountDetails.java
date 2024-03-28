package com.bank.prog4.service.FunctionAccount;

import com.bank.prog4.entity.Details;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.bank.prog4.ConfigDatabase.DatabaseConfig.getConnection;
@Service
public class ShowAccountDetails {
    public Details getAccount (int accountId) throws SQLException{
        String sql = "select bank_balance, loans , interest from \"Account\" inner join\n" +
                "\"Loans_bank_interest\" on \"Loans_bank_interest\".id_account = \"Account\".id where \"Account\".id = ?;";

        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setInt(1, accountId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    double bankBalance = resultSet.getDouble("bank_balance");
                    double loans = resultSet.getDouble("loans");
                    double interest = resultSet.getDouble("interest");

                    return  new Details (bankBalance, loans, interest);
                } else {
                    return null;
                }
            }
        }
    }
/*
public static void main(String[] args) {
        ShowAccountDetails showAccountDetails = new ShowAccountDetails();

        int accountId = 1;

        try {
            Details details = showAccountDetails.getAccount(accountId);

            if (details != null) {
                System.out.println("Détails Account:");
                System.out.println("Balance : " + details.getBankBalance());
                System.out.println("loans : " + details.getLoans());
                System.out.println("interest : " + details.getInterest());
            } else {
                System.out.println("Account not found : " + accountId);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
 */

}

