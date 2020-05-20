package db;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConn {

    @SneakyThrows
    public static Connection create(String url, String username, String password) {
        return DriverManager.getConnection(url, username, password);
    }

  /*@SneakyThrows
  public static Connection createFromURL(String jdbc_url) {
    return DriverManager.getConnection(jdbc_url);
  }*/

    @SneakyThrows
    public static Connection createFromURL(String jdbc_url, String jdbc_username, String jdbc_password) {

        return DriverManager.getConnection(jdbc_url, jdbc_username, jdbc_password);
    }

}
