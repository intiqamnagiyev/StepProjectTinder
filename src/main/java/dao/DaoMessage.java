package dao;



import java.util.List;

public interface DaoMessage<A> {
    List<A> getAll(long fromId, long toId);
    void save(A a);
}
