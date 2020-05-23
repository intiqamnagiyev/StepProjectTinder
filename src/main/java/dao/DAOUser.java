package dao;
import java.util.List;
import java.util.Optional;

public interface DAOUser<A> {
    void save(A a);

    Optional<A> getUserByEmail(String email);

    Optional<A> getUserToShow(long id);

    void like(long who_id, int whom_id);

    List<A> getLikedUsersList(long id);

    Optional<A> get(long id);
    void reset();


}
