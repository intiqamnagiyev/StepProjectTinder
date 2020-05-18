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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public Optional<User> getUserByEmail(String email) {
        Connection connection;
        PreparedStatement ps;
        ResultSet rs;
        Optional<User> optionalUser = Optional.empty();
        try {
            connection = DbConnection.getConnection();

            ps = connection.prepareStatement(SqlQuerry.GET_USER_BY_EMAIL);
            ps.setString(1, email);
            rs = ps.executeQuery();

            while (rs.next()) {
                User user = getUserFromResultSet(rs);
                optionalUser = Optional.of(user);
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
        user.setDayAgo(rs.getString("day"));
        user.setPhotoLink(rs.getString("photo"));
        return user;
    }

    @Override
    public Optional<User> getUserToShow(long id) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Optional<User> optionalUser = Optional.empty();
        try {
            connection = DbConnection.getConnection();


            ps = connection.prepareStatement(SqlQuerry.GET_DISLIKED_USER);
            ps.setLong(1, id);
            ps.setLong(2, id);

            rs = ps.executeQuery();
            while (rs.next()) {
                User user = getUserFromResultSet(rs);
                optionalUser = Optional.of(user);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return optionalUser;

    }

    @Override
    public List<User> getLikedUsersList() {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        final ArrayList<User> users = new ArrayList<>();
        try {
            connection = DbConnection.getConnection();

            ps = connection.prepareStatement(SqlQuerry.GET_ALL_LIKED_USERS);
            ps.setLong(1, Session.getUser().getId());

            rs = ps.executeQuery();
            while (rs.next()) {
                User user = getUserFromResultSet(rs);
                users.add(user);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }

    @Override
    public void like(int id) {
        Connection connection = null;
        PreparedStatement ps ;

        try {
            connection = DbConnection.getConnection();
            connection.setAutoCommit(false);

            ps = connection.prepareStatement(SqlQuerry.INSERT_LIKED_USER);
            ps.setLong(1, Session.getUser().getId());
            ps.setLong(2, id);

            ps.executeUpdate();
            connection.commit();
        } catch (SQLException sqlException) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException throwables) {
                throw new RuntimeException("smth wet wrong");
            }
            throw new RuntimeException("smth wet wrong");
        }

    }

    @Override
    public void save(User user) {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = DbConnection.getConnection();
            connection.setAutoCommit(false);

            ps = connection.prepareStatement(SqlQuerry.SAVE_USER);
            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setString(3, user.getJob());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getPhotoLink());
            final int i = ps.executeUpdate();

        } catch (SQLException sqlException) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException sx) {
                throw new RuntimeException("smth wet wrong");
            }
            throw new RuntimeException("smth wet wrong");
        } finally {
            try {
                assert ps != null;
                ps.close();
                connection.close();
            } catch (SQLException sqlException) {
                throw new RuntimeException("smth wet wrong");
            }

        }
    }

    @Override
    public Optional<User> get(long id) {

        Connection connection;
        PreparedStatement ps;
        ResultSet rs;
        Optional<User> optionalUser = Optional.empty();
        try {
            connection = DbConnection.getConnection();

            ps = connection.prepareStatement(SqlQuerry.GET_USER_BY_ID);
            ps.setLong(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                User user = getUserFromResultSet(rs);
                optionalUser = Optional.of(user);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return optionalUser;
    }
}

