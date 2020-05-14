package service.impl;

import model.Message;
import repository.MessageRepository;
import repository.impl.MessageRepositoryImpl;
import service.MessageService;

import java.util.List;

public class MessageServiceImpl implements MessageService {
    private MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public long save(String message, long from, long to) {
       return messageRepository.save(message, from, to);
    }

    @Override
    public List<Message> get(long from, long to) {
        return messageRepository.get(from, to);
    }
}
