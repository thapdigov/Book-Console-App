package az.turing.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {
    public Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/BookConsoleApp";
        String username = "StackStorm";
        String password = "book1234";
        return DriverManager.getConnection(url, username, password);
    }
}
