package repository;

import model.Message;

import java.util.List;

public interface MessageRepository {
    long save(String message, long from, long to);
    List<Message> get(long from, long to);
}
