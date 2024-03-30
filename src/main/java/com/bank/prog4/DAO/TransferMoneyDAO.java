package com.bank.prog4.DAO;

import com.bank.prog4.ConfigDatabase.DatabaseConfig;
import com.bank.prog4.Generic.GenericDAO;
import com.bank.prog4.entity.Account;
import com.bank.prog4.entity.Transfer_money;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.bank.prog4.ConfigDatabase.DatabaseConfig.getConnection;

@Repository
public class TransferMoneyDAO implements GenericDAO<Transfer_money> {
    @Override
    public Transfer_money save(Transfer_money toSave) throws SQLException {
        String sql = "INSERT INTO \"Transfer_money\" (ID,CREDIT_ACCOUNT,DEBIT_ACCOUNT, AMOUNT, TRANSFER_REASON, EFFECTIVE_DATE,REGISTRATION_DATE)"
                + " VALUES (?,?,?,?,?,?,?)"
                + " ON CONFLICT (id)"
                + " DO UPDATE SET id = EXCLUDED.ID, CREDIT_ACCOUNT = EXCLUDED.CREDIT_ACCOUNT,DEBIT_ACCOUNT = EXCLUDED.DEBIT_ACCOUNT,AMOUNT = EXCLUDED.AMOUNT,"
                +"TRANSFER_REASON = EXCLUDED.TRANSFER_REASON, EFFECTIVE_DATE = EXCLUDED.EFFECTIVE_DATE,"
                +"REGISTRATION_DATE = EXCLUDED.REGISTRATION_DATE"
                + " RETURNING id";


        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, toSave.getId());
            preparedStatement.setInt(2, toSave.getCredit_account());
            preparedStatement.setInt(3,toSave.getDebit_account());
            preparedStatement.setDouble(4,toSave.getAmount());
            preparedStatement.setString(5,toSave.getTransfer_reason());
            preparedStatement.setDate(6,  toSave.getEffective_date());
            preparedStatement.setDate(7,  toSave.getRegistration_date());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int generatedId = resultSet.getInt(1);
                toSave.setCredit_account(generatedId);
            }

            return toSave;
        } catch (SQLException e) {

            System.out.println("==> erreur: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public Transfer_money selectById(int id) throws SQLException {
        String sql = "SELECT * FROM \"Transfer_money\" WHERE id = ?";
        Transfer_money transferMoney = null;
        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {

                    int id_transfer = resultSet.getInt("id");
                    int credit_account = resultSet.getInt("credit_account");
                    int account_receivable = resultSet.getInt("debit_account");
                    Double amount = resultSet.getDouble("amount");
                    String reason = resultSet.getString("transfer_reason");
                    java.sql.Date effective_date = resultSet.getDate("effective_date");
                    java.sql.Date registration_date = resultSet.getDate("registration_date");

                    transferMoney = new Transfer_money(id_transfer,credit_account,account_receivable,amount,reason,effective_date,registration_date);
                }
            }
        }
        return transferMoney;
    }

    @Override
    public List<Transfer_money> findAll() throws SQLException {
        String transfer_money = "SELECT * FROM \"Transfer_money\"";
        List<Transfer_money> transferMonies = new ArrayList<>();

        try (PreparedStatement statement = getConnection().prepareStatement(transfer_money);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int accountId = resultSet.getInt("id");
                int credit = resultSet.getInt("credit_account");
                int debit = resultSet.getInt("debit_account");
                double amount = resultSet.getDouble("amount");
                String  reason = resultSet.getString("transfer_reason");
                java.sql.Date effective = resultSet.getDate("effective_date");
                java.sql.Date registration = resultSet.getDate("registration_date");

                Transfer_money transferMoney = new Transfer_money( accountId,credit,debit,amount,reason,effective,registration);
                transferMonies.add(transferMoney);
            }
        }
        return transferMonies;
    }

    @Override
    public Transfer_money update(Transfer_money update) throws SQLException {
        return null;
    }
}
