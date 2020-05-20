package dao;

import entity.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageDao implements DaoMessage<Message> {
    private Connection connection;

    public MessageDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Message> getAll(long fromId, long toId) {
        ArrayList<Message> messages = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(SqlQuery.GET_MESSAGES);
            ps.setLong(1,fromId);
            ps.setLong(2,toId);
            ps.setLong(3,toId);
            ps.setLong(4,fromId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
               messages.add(new Message(rs.getLong("from_user")==fromId?"sent":"received",rs.getString("content")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messages;
    }

    @Override
    public void save(Message message)  {
        PreparedStatement ps;
        try{
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(SqlQuery.INSERT_MESSAGE);
            ps.setLong(1,message.getFromId());
            ps.setLong(2,message.getToId());
            ps.setString(3,message.getMessage());
            ps.executeUpdate();
            connection.commit();
        }catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }
}
