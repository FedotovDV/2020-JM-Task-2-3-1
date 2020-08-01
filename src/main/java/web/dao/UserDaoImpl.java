package web.dao;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class.getName());

    @PersistenceContext
    private EntityManager entityManager;


//    CREATE DATABASE  IF NOT EXISTS `jm_core_task`;
//    USE `jm_core_task`;
//
//    DROP TABLE IF EXISTS `user`;
//
//    CREATE TABLE `user` (
//            `id` bigint NOT NULL AUTO_INCREMENT,
//  `name` varchar(45) DEFAULT NULL,
//  `last_name` varchar(45) DEFAULT NULL,
//  `email` varchar(60) DEFAULT NULL,
//    PRIMARY KEY (`id`)
//) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


    public UserDaoImpl() {
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUsers() {
        return entityManager.createQuery("select U from User U").getResultList();
    }

    @Override
    public void addUser(User user) {
        LOGGER.info("add User is {}", user.getId());
        System.out.println("add User");
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(Long id) {
        LOGGER.info("delete User is {}", id);
        entityManager.remove(getUserById(id));
    }

    @Override
    public void updateUser(User user) {
        LOGGER.info("update User is {}", user.getId());
        System.out.println("update User");
        entityManager.merge(user);
    }

    @Override
    public User getUserById(Long id) {
        LOGGER.info("get User is {}", id);
        return entityManager.find(User.class, id);
    }
}
