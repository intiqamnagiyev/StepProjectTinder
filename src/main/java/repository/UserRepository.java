package repository;

import model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User> getUserByEmail(String email);

    Optional<User> getDisLikedUser();

    List<User> getLikedUsersList();
}
