package com.speed.mixer.service;

import com.speed.mixer.model.User;

import java.util.List;

/**
 * Created by sambit on 2/10/2017.
 */
public interface UserService {
    User findById(int id);

    User findBySSO(String sso);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserBySSO(String sso);

    List<User> findAllUsers();

    boolean isUserSSOUnique(Integer id, String sso);
}
