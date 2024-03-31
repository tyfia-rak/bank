package com.bank.prog4.DAO;

import com.bank.prog4.Generic.GenericDAO;
import com.bank.prog4.entity.RetreatHistory;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.bank.prog4.ConfigDatabase.DatabaseConfig.getConnection;

@Repository
public class RetreatHistoryDAO implements GenericDAO<RetreatHistory> {
    @Override
    public RetreatHistory save(RetreatHistory toSave) throws SQLException {
        return null;
    }

    @Override
    public RetreatHistory selectById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<RetreatHistory> findAll() throws SQLException {
        String sql = "select \"Retreat\".id, first_name, last_name, amount, date from  \"Retreat\" "+
                "inner join \"Account\" on \"Account\".id = \"Retreat\".id_account ";
        List<RetreatHistory> retreatHistories = new ArrayList<>();

        try (PreparedStatement statement = getConnection().prepareStatement(sql)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                Double amount = resultSet.getDouble("amount");
                Date date = resultSet.getDate("date");

            RetreatHistory retreatHistory = new RetreatHistory(id,firstName,lastName,amount,date);
            retreatHistories.add(retreatHistory);
            }
        }
        return  retreatHistories;
    }

    @Override
    public RetreatHistory update(RetreatHistory update) throws SQLException {
        return null;
    }
}
