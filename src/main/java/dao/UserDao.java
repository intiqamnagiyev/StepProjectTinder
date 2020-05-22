package dao;

import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDao implements DAOUser<User> {
    private final Connection connection;

    public UserDao(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void save(User user) {
        PreparedStatement ps;
        try {
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(SqlQuery.SAVE_USER);
            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setString(3, user.getJob());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getPhotoLink());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException("smth went wrong");
            }

            throw new RuntimeException("smth went wrong");
        }
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = connection.prepareStatement(SqlQuery.GET_USER_BY_EMAIL);
            ps.setString(1, email);
            rs = ps.executeQuery();
            return !rs.next() ? Optional.empty() : Optional.of(
                    getUserFromResultSet(rs)
            );
        } catch (SQLException e) {
            return Optional.empty();
        }

    }

    private User getUserFromResultSet(ResultSet rs) throws SQLException {
        return new User(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("surname"),
                rs.getString("email"),
                rs.getString("job"),
                rs.getTimestamp("last_login").toLocalDateTime(),
                rs.getString("password"),
                rs.getString("day"),
                rs.getString("photo")
        );
    }

    @Override
    public Optional<User> getUserToShow(long id) {
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = connection.prepareStatement(SqlQuery.GET_DISLIKED_USER);
            ps.setLong(1, id);
            ps.setLong(2, id);
            rs = ps.executeQuery();
            return !rs.next() ? Optional.empty() : Optional.of(
                    getUserFromResultSet(rs)
            );
        } catch (SQLException e) {
            return Optional.empty();
        }

    }

    @Override
    public void like(long who_id, int whom_id) {
        PreparedStatement ps;
        try {
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(SqlQuery.INSERT_LIKED_USER);
            ps.setLong(1, who_id);
            ps.setLong(2, whom_id);
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            throw new RuntimeException("smth went wrong");
        }
    }

    @Override
    public List<User> getLikedUsersList(long id) {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<User> users = new ArrayList<>();
        try {
            ps = connection.prepareStatement(SqlQuery.GET_ALL_LIKED_USERS);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                users.add(getUserFromResultSet(rs));
            }
        } catch (SQLException e) {
            return new ArrayList<>();
        }
        return users;
    }

    @Override
    public Optional<User> get(long id) {
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = connection.prepareStatement(SqlQuery.GET_USER_BY_ID);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            return !rs.next() ? Optional.empty() : Optional.of(
                    getUserFromResultSet(rs)
            );
        } catch (SQLException e) {
            return Optional.empty();
        }

    }

}

