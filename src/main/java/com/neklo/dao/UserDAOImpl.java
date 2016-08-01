package com.neklo.dao;

import com.neklo.entities.User;
import com.neklo.utils.HashPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by vladosby on 15.01.15.
 */

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private HashPassword hashPassword;

    private String SQL_FIND_ALL_ROLE = "select * from user";
    private String SQL_FIND_USER_BY_ID = "from User where userId = :id";
    private String SQL_DELETE_USER = "delete User where userId = :id";


    // Used SQL
    public List<User> findAllUser() {
        Query query = em.createNativeQuery(SQL_FIND_ALL_ROLE, User.class);
        return query.getResultList();
    }

    //Used HQL
    public User findUserById(int id) {
        TypedQuery<User> query = em.createQuery(SQL_FIND_USER_BY_ID, User.class);
        query.setParameter("id", id);

        return query.getSingleResult();
    }

    //Used API EntityManager
    public void saveUser(User user) {
        User userWithHashPassword = user;
        userWithHashPassword.setPassword(hashPassword.convertPasswordToHashCode(userWithHashPassword.getPassword()));
        em.persist(userWithHashPassword);
    }

    public void deleteUser(int id) {
        Query query = em.createQuery(SQL_DELETE_USER);
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
