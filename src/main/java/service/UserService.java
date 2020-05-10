package service;

import model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> getUserByEmail(String email);

    Optional<User> getDislikedUser();

    List<User> getLikedUsersList();
}
