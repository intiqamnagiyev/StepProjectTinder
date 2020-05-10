package repository.impl;

import filter.Session;
import jdbc.DbConnection;
import model.User;
import repository.UserRepository;
import sql.SqlQuerry;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public Optional<User> getUserByEmail(String email) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Optional<User> optionalUser =Optional.empty();
        try {
            connection = DbConnection.getConnection();
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(SqlQuerry.GET_USER_BY_EMAIL);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()){
              User user= getUserFromResultSet(rs);
              optionalUser=Optional.of(user);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return optionalUser;
    }

    private User getUserFromResultSet(ResultSet rs) throws SQLException {
        final User user = new User();
        user.setId(rs.getLong("id"));
        user.setName(rs.getString("name"));
        user.setSurname(rs.getString("surname"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setJob(rs.getString("job"));
        user.setLastLogin(rs.getTimestamp("last_login").toLocalDateTime());
        return user;
    }

    @Override
    public Optional<User> getUnlikedUser() {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Optional<User> optionalUser =Optional.empty();
        try {
            connection = DbConnection.getConnection();
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(SqlQuerry.GET_UNLIKED_USERS);
            ps.setLong(1, Session.getUser().getId());
            ps.setLong(2, Session.getUser().getId());
            rs = ps.executeQuery();
            while (rs.next()){
                User user= getUserFromResultSet(rs);
                optionalUser=Optional.of(user);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return optionalUser;

    }
}
