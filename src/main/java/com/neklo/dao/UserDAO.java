package com.neklo.dao;

import com.neklo.entities.User;

import java.util.List;

/**
 * Created by vladosby on 15.01.15.
 */
public interface UserDAO {
    public List<User> findAllUser();

    public User findUserById(int id);

    public void saveUser(User user);

    public void deleteUser(int id);
}
