package com.bank.prog4.DAO;

import com.bank.prog4.ConfigDatabase.DatabaseConfig;
import com.bank.prog4.Generic.GenericDAO;
import com.bank.prog4.entity.Account;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import static com.bank.prog4.ConfigDatabase.DatabaseConfig.getConnection;
@Repository
public class AccountDAO implements GenericDAO<Account> {


    @Override
    public Account save(Account toSave) throws SQLException {
        String sql = "INSERT INTO \"Account\" (FIRST_NAME, LAST_NAME, BIRTHDAY, BANK_BALANCE, BANK_NAME,SALARY_AMOUNT,OVERDRAW)"
                + " VALUES (?,?,?,?,?,?,?)"
                + " ON CONFLICT (id)"
                + " DO UPDATE SET FIRST_NAME = EXCLUDED.FIRST_NAME, LAST_NAME = EXCLUDED.LAST_NAME,BIRTHDAY = EXCLUDED.BIRTHDAY,"
                + "BANK_BALANCE = EXCLUDED.BANK_BALANCE,  BANK_NAME = EXCLUDED.BANK_NAME,SALARY_AMOUNT = EXCLUDED.SALARY_AMOUNT,OVERDRAW = EXCLUDED.OVERDRAW"
                + " RETURNING id";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, toSave.getFirstName());
            preparedStatement.setString(2, toSave.getLastName());
            preparedStatement.setDate(3, toSave.getBirthday());
            preparedStatement.setDouble(4, toSave.getBankBalance());
            preparedStatement.setString(5, toSave.getBankName());
            preparedStatement.setDouble(6, toSave.getSalaryAmount());
            preparedStatement.setBoolean(7, toSave.getOverdraw());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int generatedId = resultSet.getInt(1);
                toSave.setId(generatedId);
            }

            return toSave;
        } catch (SQLException e) {
            System.out.println("==> erreur: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public Account selectById(int id) throws SQLException {
        String sql = "SELECT * FROM \"Account\" WHERE id = ?";
        Account account = null;
        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id_account= resultSet.getInt("id");
                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_name");
                    java.sql.Date birthday = resultSet.getDate("birthday");
                    double bankBalance = resultSet.getDouble("bank_balance");
                    String bankName = resultSet.getString("bank_name");
                    double salaryAmount = resultSet.getDouble("salary_amount");
                    boolean overdrawn = resultSet.getBoolean("overdraw");

                    account = new Account( id_account,firstName, lastName, birthday, bankBalance, bankName, salaryAmount, overdrawn);
                }
            }
        }
        return account;
    }



    public List<Account> findAll() throws SQLException{
        String allAccount = "SELECT * FROM \"Account\"";
        List<Account> allAccounts = new ArrayList<>();

        try (PreparedStatement statement = getConnection().prepareStatement(allAccount);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int accountId = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                java.sql.Date birthday = resultSet.getDate("birthday");
                double bankBalance = resultSet.getDouble("bank_balance");
                String bankName = resultSet.getString("bank_name");
                double salaryAmount = resultSet.getDouble("salary_amount");
                boolean overdrawn = resultSet.getBoolean("overdraw");

                Account account = new Account( accountId,firstName, lastName, birthday, bankBalance, bankName, salaryAmount, overdrawn);
                allAccounts.add(account);
            }
        }
        return allAccounts;
    }

    @Override
    public Account update(Account update) throws SQLException {
        String up = "Update \"Account\" set bank_balance = ? where id = ?";
        try (Connection connection = DatabaseConfig.getConnection();
        PreparedStatement preparedStatement =connection.prepareStatement(up)){
            preparedStatement.setDouble(1,update.getBankBalance());
            preparedStatement.setInt(2,update.getId());
            preparedStatement.executeUpdate();
        } {

        }
        return update;
    }
}

