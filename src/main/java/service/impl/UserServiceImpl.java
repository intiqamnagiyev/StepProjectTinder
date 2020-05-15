package service.impl;

import model.User;
import repository.UserRepository;
import service.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> getUserToShow(long id) {
        return userRepository.getUserToShow(id);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    @Override
    public List<User> getLikedUsersList() {
        return userRepository.getLikedUsersList();
    }

    @Override
    public void like(int id) {
        userRepository.like(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
