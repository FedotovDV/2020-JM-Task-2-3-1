package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Autowired
    public void getUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    @Transactional
    @Override
    public List<User> allUsers() {
        return userDao.allUsers();
    }


    @Transactional
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }


    @Transactional
    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }


    @Override
    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    @Transactional
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }
}
