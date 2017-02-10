package com.speed.mixer.dao;

import com.speed.mixer.model.User;

import java.util.List;

/**
 * Created by sambit on 2/10/2017.
 */
public interface UserDao {
    User findById(int id);

    User findBySSO(String sso);

    void save(User user);

    void deleteBySSO(String sso);

    List<User> findAllUsers();
}
