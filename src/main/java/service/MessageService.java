package service;

import dao.DaoMessage;
import entity.Message;

import java.util.List;

public class MessageService {
    private final DaoMessage<Message> daoMessage;

    public MessageService(DaoMessage<Message> daoMessage) {
        this.daoMessage = daoMessage;
    }

    public void  save(String content, long from, long to){

        daoMessage.save(new Message(from,to,content));
    }
   public List<Message> getAll(long fromId, long toId){
      return daoMessage.getAll(fromId, toId);
    }
}
