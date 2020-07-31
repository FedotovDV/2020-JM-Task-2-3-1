package web.dao;


import web.model.User;

import java.util.List;

public interface UserDao {


    List<User> allUsers();
    void addUser(User user);
    void deleteUser(User user);
    void updateUser(User user);
    User getUserById(Long id);
}