package com.bank.prog4.ConfigDatabase;

import org.springframework.context.annotation.Bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseConfig {
    private static final String URL = System.getenv("url");
    private static final String USER = System.getenv("user");
    private static String PASSWORD = System.getenv("password");
    @Bean
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);

    }

}
