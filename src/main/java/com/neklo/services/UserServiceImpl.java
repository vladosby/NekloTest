package com.neklo.services;

import com.neklo.dao.UserDAO;
import com.neklo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by vladosby on 15.01.15.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    public List<User> findAllUser() {
        return userDAO.findAllUser();
    }

    public User findUserById(int id) {
        return userDAO.findUserById(id);
    }

    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }
}
