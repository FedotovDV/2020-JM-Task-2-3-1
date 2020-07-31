package web.dao;



import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl  implements UserDao {

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
//        System.out.println("ORMService queryfindAllUsersJPA is called");
//        String query = "select U from User U";
//        TypedQuery<User> typedQuery = entityManager.createQuery(query, User.class);
//        return typedQuery.getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(User user) {
        entityManager.remove(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }
}
