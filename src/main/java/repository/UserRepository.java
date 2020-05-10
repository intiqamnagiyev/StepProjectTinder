package repository;

import model.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> getUserByEmail(String email);

    Optional<User> getUnlikedUser();
}
