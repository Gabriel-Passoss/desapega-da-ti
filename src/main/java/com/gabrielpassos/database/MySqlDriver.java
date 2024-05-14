package com.gabrielpassos.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDriver {
    private final String databaseUrl = "jdbc:mysql://localhost:3306/desapega?useTimezone=true&serverTimezone=UTC";
    private final String user = "admin";
    private final String password = "unisul";

    private static Connection connection;

    public Connection getConnection() {
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(this.databaseUrl, this.user, this.password);

                return connection;
            }
            return connection;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
