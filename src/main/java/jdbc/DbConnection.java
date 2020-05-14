package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String URL="jdbc:postgresql://localhost:5432/Tinder";
    private static final String NAME="intiqam";
    private static final String PWD="test123456";

    private static final String URL1="jdbc:postgresql://ec2-34-230-149-169.compute-1.amazonaws.com:5432/d73npims32mpl0";
    private static final String NAME1="ggeswkxjkjsxvd";
    private static final String PWD1="dbd2de1aeab61843aaac6809e5665a4142102e2069f27fa09d3c2d311626fc44";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL1, NAME1, PWD1);
    }

    public static void main(String[] args) throws SQLException {
        final Connection connection = DriverManager.getConnection(URL, NAME, PWD);
    }
}
