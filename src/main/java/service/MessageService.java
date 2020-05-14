package service;

import model.Message;

import java.util.List;

public interface MessageService {
    long save(String message,long from, long to);
    List<Message> get(long from, long to);
}
