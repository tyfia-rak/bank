package com.bank.prog4.DAO;

import com.bank.prog4.Generic.GenericDAO;
import com.bank.prog4.entity.Account;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.bank.prog4.ConfigDatabase.DatabaseConfig.getConnection;
@Repository
public class AccountDAO implements GenericDAO<Account> {


    @Override
    public Account save(Account toSave) throws SQLException {
        /*
         INSERT INTO "Account" (FIRST_NAME, LAST_NAME, BIRTHDAY, BANK_BALANCE, BANK_NAME, SALARY_AMOUNT)
        VALUES ('John', 'Doe', '1990-05-15', 50000.00, 'Bank of XYZ', 6000.00),
         */
        String sql = "INSERT INTO \"Account\" (FIRST_NAME, LAST_NAME, BIRTHDAY, BANK_BALANCE, BANK_NAME, SALARY_AMOUNT)\n" +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = getConnection().prepareStatement(sql)){
            statement.setString(1,toSave.getFirst_name());
            statement.setString(2,toSave.getLastName());
            statement.setDate(3,toSave.getBirthday());
            statement.setDouble(4,toSave.getBank_balance());
            statement.setString(5,toSave.getBank_name());
            statement.setDouble(6,toSave.getSalary_amount());
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
