package com.bank.prog4.DAO;

import com.bank.prog4.ConfigDatabase.DatabaseConfig;
import com.bank.prog4.entity.Transfer_money;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransferDAO {
    private static final String INSERT_TRANSFER_QUERY = "INSERT INTO transfers (credit_account, account_receivable, amount, transfer_reason, type, effective_date, registration_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_ACCOUNT_BALANCE_QUERY = "UPDATE accounts SET balance = balance - ? WHERE account_number = ?";
    private static final String RECEIVE_TRANSFER_QUERY = "UPDATE accounts SET balance = balance + ? WHERE account_number = ?";

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
                insertStatement.setInt(2, transfer.getAccount_receivable());
                insertStatement.setDouble(3, transfer.getAmount());
                insertStatement.setString(4, transfer.getTransfer_reason());
                insertStatement.setString(5, transfer.getType());
                insertStatement.setDate(6, new java.sql.Date(transfer.getEffective_date().getTime()));
                insertStatement.setDate(7, new java.sql.Date(transfer.getRegistration_date().getTime()));
                insertStatement.executeUpdate();
            }

            // Credit money to the receiver's account
            if (transfer.getType().equals("internal")) {
                try (PreparedStatement receiveStatement = connection.prepareStatement(RECEIVE_TRANSFER_QUERY)) {
                    receiveStatement.setDouble(1, transfer.getAmount());
                    receiveStatement.setInt(2, transfer.getAccount_receivable());
                    receiveStatement.executeUpdate();
                }
            }

            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
