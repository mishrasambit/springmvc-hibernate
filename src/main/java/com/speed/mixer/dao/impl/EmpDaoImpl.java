package com.speed.mixer.dao.impl;

import com.speed.mixer.dao.AbstractDao;
import com.speed.mixer.dao.EmpDao;
import com.speed.mixer.model.Emp;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sambit on 2/10/2017.
 */

@Repository("empDao")
public class EmpDaoImpl extends AbstractDao<Integer, Emp> implements EmpDao {

    @Override
    public Emp findById(int id) {
        Emp emp = getByKey(id);
        return emp;
    }



    @Override
    public void save(Emp user) {
        persist(user);
    }

    @Override
    public void deleteBySSO(String sso) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("ssoId", sso));
        Emp user = (Emp)crit.uniqueResult();
        delete(user);
    }

    @Override
    public List<Emp> findAllEmp() {
        /*Criteria criteria = createEntityCriteria().addOrder(Order.asc("firstName"));
        System.out.println(criteria.toString());
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Emp> empList = (List<Emp>) criteria.list();*/

        List<Emp> empList=null;
        Session session=null;
            session = getSession();

            Query query = session.createQuery("FROM Emp emp");
            empList =(List<Emp>) query.list();

        return empList;
    }
}
