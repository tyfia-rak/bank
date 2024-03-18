package com.bank.prog4.DAO;

import com.bank.prog4.Generic.GenericDAO;
import com.bank.prog4.entity.Account;
import org.springframework.stereotype.Repository;

import java.sql.Date;
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
            statement.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


/*
public static void main(String[] args) {
        // Créer un objet Account avec des valeurs
        Account accountToSave = new Account();
        accountToSave.setFirst_name("John");
        accountToSave.setLastName("Doe");
        accountToSave.setBirthday(new Date(1990, 5, 15)); // Note: La classe Date est obsolète, envisagez d'utiliser java.time.LocalDate
        accountToSave.setBank_balance(50000.00);
        accountToSave.setBank_name("Bank of XYZ");
        accountToSave.setSalary_amount(6000.00);

        // Créer une instance de la classe où se trouve la méthode save
        AccountDAO accountDAO = new AccountDAO();

        try {
            // Appeler la méthode save pour insérer l'objet dans la base de données
            accountDAO.save(accountToSave);
            System.out.println("L'objet Account a été inséré avec succès dans la base de données.");
        } catch (SQLException e) {
            // Gérer les exceptions SQL
            e.printStackTrace();
        }
    }
 */

}
