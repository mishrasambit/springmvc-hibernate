package com.speed.mixer.service;

import com.speed.mixer.model.UserProfile;

import java.util.List;

/**
 * Created by sambit on 2/10/2017.
 */
public interface UserProfileService {

    UserProfile findById(int id);

    UserProfile findByType(String type);

    List<UserProfile> findAll();
}
