package repository;

import model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User> getUserByEmail(String email);

    Optional<User> getUserToShow(long id);

    List<User> getLikedUsersList();

    void like(int id);

    void save(User user);
}
