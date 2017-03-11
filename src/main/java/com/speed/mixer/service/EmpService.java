package com.speed.mixer.service;

import com.speed.mixer.model.Emp;

import java.util.List;

/**
 * Created by sambit on 2/10/2017.
 */
public interface EmpService {
    Emp findById(int id);

    void saveEmp(Emp user);

    void deleteUserBySSO(String sso);

    boolean isUserSSOUnique(Integer id, String sso);

    List<Emp> findAllEmp();
}
