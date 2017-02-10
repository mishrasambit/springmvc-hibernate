package com.speed.mixer.dao;

import com.speed.mixer.model.UserProfile;

import java.util.List;

/**
 * Created by sambit on 2/10/2017.
 */
public interface UserProfileDao {
    List<UserProfile> findAll();
    UserProfile findByType(String type);
    UserProfile findById(int id);
}
