package com.bank.prog4.DAO;

import com.bank.prog4.ConfigDatabase.DatabaseConfig;
import com.bank.prog4.entity.Transfer_money;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransferDAO {
    private static final String INSERT_TRANSFER_QUERY = "INSERT INTO transfers (credit_account, account_receivable, amount, transfer_reason, type, effective_date, registration_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_ACCOUNT_BALANCE_QUERY = "UPDATE \"Account\" SET bank_balance = bank_balance - ? WHERE id = ?";
    private static final String RECEIVE_TRANSFER_QUERY = "UPDATE \"Account\" SET bank_balance = bank_balance + ? WHERE id = ?";

    public void makeTransfer(Transfer_money transfer) throws SQLException {
        try (Connection connection = DatabaseConfig.getConnection();){
            // Deduct money from the sender's account
            try (PreparedStatement updateStatement = connection.prepareStatement(UPDATE_ACCOUNT_BALANCE_QUERY)) {
                updateStatement.setDouble(1, transfer.getAmount());
                updateStatement.setInt(2, transfer.getCredit_account());
                updateStatement.executeUpdate();
            }

            // Record the transfer
            try (PreparedStatement insertStatement = connection.prepareStatement(INSERT_TRANSFER_QUERY)) {
                insertStatement.setInt(1, transfer.getCredit_account());
                insertStatement.setInt(2, transfer.getDebit_account());
                insertStatement.setDouble(3, transfer.getAmount());
                insertStatement.setString(4, transfer.getTransfer_reason());
                insertStatement.setDate(5, new java.sql.Date(transfer.getEffective_date().getTime()));
                insertStatement.setDate(6, new java.sql.Date(transfer.getRegistration_date().getTime()));
                insertStatement.executeUpdate();
            }

            // Check if the recipient account is in the same bank
            if (transfer.getAmount()==0) {
                // Credit money to the receiver's account immediately
                try (PreparedStatement receiveStatement = connection.prepareStatement(RECEIVE_TRANSFER_QUERY)) {
                    receiveStatement.setDouble(1, transfer.getAmount());
                    receiveStatement.setInt(2, transfer.getDebit_account());
                    receiveStatement.executeUpdate();
                }
            } else {
                // For transfers to accounts in other banks, wait for 48 hours before deducting the amount
                // Simulate 48 hours delay (you can implement this asynchronously in a real-world scenario)
                Thread.sleep(48 * 60 * 60 * 1000); // 48 hours in milliseconds

                // Deduct money from the sender's account after 48 hours
                try (PreparedStatement updateStatement = connection.prepareStatement(UPDATE_ACCOUNT_BALANCE_QUERY)) {
                    updateStatement.setDouble(1, transfer.getAmount());
                    updateStatement.setInt(2, transfer.getDebit_account());
                    updateStatement.executeUpdate();
                }
            }

        } catch (SQLException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
