package com.bank.prog4.service.FunctionAccount;

import com.bank.prog4.entity.Account;
import com.bank.prog4.entity.Retreat;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;




import static com.bank.prog4.ConfigDatabase.DatabaseConfig.getConnection;
@Service
public class RetreatAccount {
    public static void DoRetreat(Retreat retreat, Account account) throws SQLException {
        String insertRetreat = "INSERT INTO \"Retreat\" (amount, date_transaction, id_account) values" +
                "(?, ?, ?)";

        try (PreparedStatement retreatStatement = getConnection().prepareStatement(insertRetreat)){
            retreatStatement.setDouble(1,retreat.getAmount());
            retreatStatement.setDate(2, (Date) retreat.getTransaction_date());
            retreatStatement.setInt(3,retreat.getId_account());
            retreatStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        String updateAccount = "update \"Account\" set Bank_balance = Bank_balance - ? where id = ?;";

        try (PreparedStatement accountStatement = getConnection().prepareStatement(updateAccount)){
            accountStatement.setDouble(1,account.getBank_balance());
            accountStatement.setInt(2,account.getId());
            accountStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws ParseException, SQLException {
        Retreat retreat = new Retreat();
        retreat.setAmount(10000.00);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            java.util.Date utilDate = dateFormat.parse("21-12-2025");

            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            retreat.setTransaction_date(sqlDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        retreat.setId_account(1);

        Account account = new Account();
        account.setBank_balance(10000.00);
        account.setId(1);
        try {
            DoRetreat(retreat, account);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
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
