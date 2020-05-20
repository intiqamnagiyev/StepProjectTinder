package service;

import dao.DAOUser;
import entity.User;

import java.util.List;
import java.util.Optional;

public class UserService {
private DAOUser<User> dao;

    public UserService(DAOUser<User> dao) {
        this.dao = dao;
    }

   public void save(User user){
        dao.save(user);
    }

    public Optional<User> getUserByEmail(String email) {

        return dao.getUserByEmail(email);
    }

    public Optional<User> getUserToShow(long id) {
        return dao.getUserToShow(id);
    }

    public void like(long who_id, int whom_id) {
        dao.like(who_id, whom_id);
    }

    public List<User> getLikedUsersList(long id) {
        return dao.getLikedUsersList(id);
    }

    public Optional<User> get(int id) {
        return dao.get(id);
    }
}
