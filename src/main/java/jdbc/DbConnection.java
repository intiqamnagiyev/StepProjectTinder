package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String URL="jdbc:postgresql://localhost:5432/Tinder";
    private static final String NAME="intiqam";
    private static final String PWD="test123456";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, NAME, PWD);
    }

    public static void main(String[] args) throws SQLException {
        final Connection connection = DriverManager.getConnection(URL, NAME, PWD);
    }
}
