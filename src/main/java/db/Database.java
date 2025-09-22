package db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

abstract public class Database {

    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        if (connection == null) {

            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    "nilmar");
            System.out.println("CONECTADO...");
        }

        return connection;
    }
}
