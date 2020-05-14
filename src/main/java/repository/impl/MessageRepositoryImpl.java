package repository.impl;

import filter.Session;
import jdbc.DbConnection;
import model.Message;
import repository.MessageRepository;
import sql.SqlQuerry;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MessageRepositoryImpl implements MessageRepository {
    @Override
    public long save(String message, long from, long to) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        long id = 0;
        try {
            connection = DbConnection.getConnection();
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(SqlQuerry.INSERT_MESSAGE, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setLong(1, from);
            ps.setLong(2, to);
            ps.setString(3, message);
            final int i = ps.executeUpdate();
            if (i > 0) {
                rs = ps.getGeneratedKeys();
                while (rs.next()) {
                    id = rs.getLong("id");
                }
            }


        } catch (SQLException throwables) {
            try {
                assert connection != null;
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        } finally {
            try {
                assert connection != null;
                connection.commit();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return id;
    }

    @Override
    public List<Message> get(long from, long to) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        final ArrayList<Message> messages = new ArrayList<>();
        try {
            connection = DbConnection.getConnection();
            ps = connection.prepareStatement(SqlQuerry.GET_MESSAGES);
            ps.setLong(1, from);
            ps.setLong(2, to);
            ps.setLong(3, to);
            ps.setLong(4, from);
            rs = ps.executeQuery();
            while (rs.next()) {
                Message message = getMessageFromResultSet(rs);
                message.setWriteTo(to);
                messages.add(message);
            }
        } catch (SQLException x) {
            throw new RuntimeException("smth went wrong");
        }
        return messages;
    }

    private Message getMessageFromResultSet(ResultSet rs) throws SQLException {
        final Message message = new Message();
        final long from_user = rs.getLong("from_user");
        message.setType(from_user== Session.getUser().getId()?"sent":"received");
        message.setMessage(rs.getString("content"));
        return message;
    }
}
