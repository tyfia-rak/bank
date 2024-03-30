package com.bank.prog4.DAO;

import com.bank.prog4.ConfigDatabase.DatabaseConfig;
import com.bank.prog4.Generic.GenericDAO;
import com.bank.prog4.entity.Account;
import com.bank.prog4.entity.Retreat;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.bank.prog4.ConfigDatabase.DatabaseConfig.getConnection;
@Repository
public class RetreatDAO implements GenericDAO<Retreat> {
    @Override
    public Retreat save(Retreat toSave) throws SQLException {
        String sql = "INSERT INTO \"Retreat\" (id,amount , date, id_account)"
                + " VALUES (?,?,?,?)"
                + " ON CONFLICT (id)"
                + " DO UPDATE SET id = EXCLUDED.ID, amount = EXCLUDED.AMOUNT,date = EXCLUDED.DATE,"
                + "ID_ACCOUNT = EXCLUDED.ID_ACCOUNT"
                + " RETURNING id";


        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1,toSave.getId());
            preparedStatement.setDouble(2,toSave.getAmount());
            preparedStatement.setDate(  3, toSave.getTransaction_date());
            preparedStatement.setInt(  4, toSave.getId_account());

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
    public Retreat selectById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Retreat> findAll() throws SQLException {
        String allretreat = "SELECT * FROM \"Retreat\"";
        List<Retreat> allRetreat = new ArrayList<>();

        try (PreparedStatement statement = getConnection().prepareStatement(allretreat);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                double amount = resultSet.getDouble("amount");
                java.sql.Date date = resultSet.getDate("date");
                int id_account = resultSet.getInt("id_account");


                Retreat retreat = new Retreat( id,amount,date,id_account);
                allRetreat.add(retreat);
            }
        }
        return allRetreat;
    }

    @Override
    public Retreat update(Retreat update) throws SQLException {
        return null;
    }
}
