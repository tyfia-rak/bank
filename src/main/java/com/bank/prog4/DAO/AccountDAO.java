package com.bank.prog4.DAO;

import com.bank.prog4.ConfigDatabase.DatabaseConfig;
import com.bank.prog4.Generic.GenericDAO;
import com.bank.prog4.entity.Account;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import static com.bank.prog4.ConfigDatabase.DatabaseConfig.getConnection;
@Repository
public class AccountDAO implements GenericDAO<Account> {


    @Override
    public Account save(Account toSave) throws SQLException {
        String sql = "INSERT INTO \"Account\" (ID,FIRST_NAME, LAST_NAME, BIRTHDAY, BANK_BALANCE, BANK_NAME,SALARY_AMOUNT,OVERDRAW)"
                + " VALUES (?,?,?,?,?,?,?,?)"
                + " ON CONFLICT (id)"
                + " DO UPDATE SET FIRST_NAME = EXCLUDED.FIRST_NAME, LAST_NAME = EXCLUDED.LAST_NAME,BIRTHDAY = EXCLUDED.BIRTHDAY,"
        +"BANK_BALANCE = EXCLUDED.BANK_BALANCE,  BANK_NAME = EXCLUDED.BANK_NAME,OVERDRAW = EXCLUDED.OVERDRAW"
                + " RETURNING id";


        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, toSave.getId());
            preparedStatement.setString(2,toSave.getFirstName());
            preparedStatement.setString(3,toSave.getLastName());
            preparedStatement.setDate(4,toSave.getBirthday());
            preparedStatement.setDouble(5,toSave.getBankBalance());
            preparedStatement.setString(6,toSave.getBankName());
            preparedStatement.setDouble(7,toSave.getSalaryAmount());
            preparedStatement.setBoolean(8,toSave.getOverdraw());

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

                    int accountId = resultSet.getInt("id");
                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_name");
                    java.sql.Date birthday = resultSet.getDate("birthday");
                    double bankBalance = resultSet.getDouble("bank_balance");
                    String bankName = resultSet.getString("bank_name");
                    double salaryAmount = resultSet.getDouble("salary_amount");
                    boolean overdrawn = resultSet.getBoolean("overdraw");

                    account = new Account(accountId, firstName, lastName, birthday, bankBalance, bankName, salaryAmount, overdrawn);
                }
            }
        }
        return account;
    }

    @Override
    public List<Account> findAll() {
        List<Account> accounts = new ArrayList<>();

        String sql = "SELECT * FROM \"Account\";";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Account account = new Account();
                account.setId(resultSet.getInt("id"));
                account.setFirstName(resultSet.getString("first_name"));
                account.setLastName(resultSet.getString("last_name"));
                account.setBirthday(resultSet.getDate("birthday"));
                account.setBankBalance(resultSet.getDouble("bank_balance"));
                account.setBankName(resultSet.getString("bank_name"));
                account.setSalaryAmount(resultSet.getDouble("salary_amount"));
                account.setOverdraw(resultSet.getBoolean("overdraw"));

                accounts.add(account);
            }

        } catch (SQLException e) {
            System.out.println("==> erreur: " + e.getMessage());
        }

        return accounts;
    }

}
