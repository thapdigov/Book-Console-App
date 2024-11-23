package az.turing.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {
    public Connection getConnection() throws SQLException {
        String url = System.getenv("Postgres_Url");
        String username = System.getenv("Postgres_User");
        String password = System.getenv("Password");
        return DriverManager.getConnection(url, username, password);
    }
}
