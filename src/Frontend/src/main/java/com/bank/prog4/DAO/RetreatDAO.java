package com.bank.prog4.DAO;

import com.bank.prog4.ConfigDatabase.DatabaseConfig;
import com.bank.prog4.Generic.GenericDAO;
import com.bank.prog4.entity.Retreat;

import java.sql.*;
import java.util.List;

public class RetreatDAO implements GenericDAO<Retreat> {
    @Override
    public Retreat save(Retreat toSave) throws SQLException {
        String sql = "INSERT INTO \"Retreat\" (amount , date_transaction, id_account)"
                + " VALUES (?,?,?)"
                + " ON CONFLICT (id)"
                + " DO UPDATE SET amount = EXCLUDED.AMOUNT,date_transaction = EXCLUDED.DATE_TRANSACTION,"
                + "ID_ACCOUNT = EXCLUDED.ID_ACCOUNT"
                + " RETURNING id";


        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDouble(1,toSave.getAmount());
            preparedStatement.setDate(  2, toSave.getTransaction_date());
            preparedStatement.setInt(  3, toSave.getId_account());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int generatedId = resultSet.getInt(1);
                toSave.setAmount(generatedId);
            }

            return toSave;
        } catch (SQLException e) {
            System.out.println("==> erreur: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public Retreat selectById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Retreat> findAll() {
        return null;
    }
}
