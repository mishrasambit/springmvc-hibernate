package com.speed.mixer.dao.impl;

import com.speed.mixer.dao.AbstractDao;
import com.speed.mixer.dao.EmpDao;
import com.speed.mixer.model.Emp;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
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
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("firstName"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Emp> empList = (List<Emp>) criteria.list();

        // No need to fetch userProfiles since we are not showing them on list page. Let them lazy load.
        // Uncomment below lines for eagerly fetching of userProfiles if you want.
        /*
        for(User user : users){
            Hibernate.initialize(user.getUserProfiles());
        }*/
        return empList;
    }
}
