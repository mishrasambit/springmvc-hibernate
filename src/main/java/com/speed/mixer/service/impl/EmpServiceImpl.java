package com.speed.mixer.service.impl;

import com.speed.mixer.dao.EmpDao;
import com.speed.mixer.model.Emp;
import com.speed.mixer.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sambit on 2/10/2017.
 */

@Service("empService")
@Transactional
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDao dao;

    @Override
    public Emp findById(int id) {
        return dao.findById(id);
    }

    @Override
    public void saveUser(Emp user) {
        dao.save(user);
    }



    @Override
    public void deleteUserBySSO(String sso) {
        dao.deleteBySSO(sso);
    }

    @Override
    public List<Emp> findAllEmp() {
        return dao.findAllEmp();
    }

    @Override
    public boolean isUserSSOUnique(Integer id, String sso) {
        return false;
    }


}
