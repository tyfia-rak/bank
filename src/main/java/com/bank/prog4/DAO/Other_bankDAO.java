package com.bank.prog4.DAO;

import com.bank.prog4.ConfigDatabase.DatabaseConfig;
import com.bank.prog4.Generic.GenericDAO;
import com.bank.prog4.entity.Account;
import com.bank.prog4.entity.Other_bank;
import org.springframework.stereotype.Repository;

import java.lang.ref.PhantomReference;
import java.sql.*;
import java.util.List;

import static com.bank.prog4.ConfigDatabase.DatabaseConfig.getConnection;

@Repository
public class Other_bankDAO implements GenericDAO<Other_bank> {
    @Override
    public Other_bank save(Other_bank toSave) throws SQLException {
        String sql = "INSERT INTO \"Other_bank\" (ID,AMOUNT, BANK_NAME, TRANSFER_REASON, EFFECTIVE_DATE, REGISTRATION_DATE, ID_ACCOUNT)"
                + " VALUES (?,?,?,?,?,?,?)"
                + " ON CONFLICT (id)"
                + " DO UPDATE SET AMOUNT = EXCLUDED.AMOUNT, BANK_NAME = EXCLUDED.BANK_NAME,TRANSFER_REASON = EXCLUDED.TRANSFER_REASON,"
                +"EFFECTIVE_DATE = EXCLUDED.EFFECTIVE_DATE, REGISTRATION_DATE = EXCLUDED.REGISTRATION_DATE, ID_ACCOUNT = EXCLUDED.ID_ACCOUNT"
                + " RETURNING id";


        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1,toSave.getId());
            preparedStatement.setDouble(2, toSave.getAmount());
            preparedStatement.setString(3,toSave.getBank_name());
            preparedStatement.setString(4, toSave.getTransfer_reason());
            preparedStatement.setDate(5, (Date) toSave.getEffective_date());
            preparedStatement.setDate(6, (Date) toSave.getRegistration_date());
            preparedStatement.setInt(7,  toSave.getId_account());


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
    public Other_bank selectById(int id) throws SQLException {
        String sql = "SELECT * FROM \"Other_bank\" WHERE id = ?";
        Other_bank otherBank = null;
        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {

                    int idOther_bank = resultSet.getInt("id");
                    Double amount = resultSet.getDouble("amount");
                    String bank_name = resultSet.getString("bank_name");
                    String transfer = resultSet.getString("transfer_reason");
                    java.sql.Date effective_date = resultSet.getDate("effective_date");
                    java.sql.Date registration_date = resultSet.getDate("registration_date");
                    int id_account = resultSet.getInt("id_account");

                    otherBank = new Other_bank(idOther_bank, amount, bank_name, transfer, effective_date, registration_date, id_account);
                }
            }
        }
        return otherBank;
    }

    @Override
    public List<Other_bank> findAll() {
        return null;
    }
}
