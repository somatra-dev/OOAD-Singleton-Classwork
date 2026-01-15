package co.pesexpo.config;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
public class DatabaseResourceConfig {

    private static DatabaseResourceConfig instance;
    private Connection connection;

    private static final String URL = "jdbc:postgresql://localhost:5222/db_a01_e1";
    private static final String USERNAME = "jdbc";
    private static final String PASSWORD = "123";

    // Private constructor
    private DatabaseResourceConfig() {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Get singleton instance
    public static DatabaseResourceConfig getInstance() {
        if (instance == null) {
            instance = new DatabaseResourceConfig();
        }
        return instance;
    }

}
