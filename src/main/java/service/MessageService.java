package service;

import dao.DaoMessage;
import entity.Message;
import lombok.AllArgsConstructor;

import java.util.List;
@AllArgsConstructor
public class MessageService {
    private final DaoMessage<Message> daoMessage;


    public void  save(String content, long from, long to){

        daoMessage.save(new Message(from,to,content));
    }
   public List<Message> getAll(long fromId, long toId){
      return daoMessage.getAll(fromId, toId);
    }

    public void reset() {
        daoMessage.reset();
    }
}
