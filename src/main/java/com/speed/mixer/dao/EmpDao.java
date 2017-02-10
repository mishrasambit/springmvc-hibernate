package com.speed.mixer.dao;

import com.speed.mixer.model.Emp;

import java.util.List;

/**
 * Created by sambit on 2/10/2017.
 */
public interface EmpDao {
    Emp findById(int id);

    void save(Emp user);

    void deleteBySSO(String sso);

    List<Emp> findAllEmp();
}
