package com.speed.mixer.dao.impl;

import com.speed.mixer.dao.AbstractDao;
import com.speed.mixer.dao.UserDao;
import com.speed.mixer.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sambit on 2/10/2017.
 */


@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

    @Override
    public User findById(int id) {
        User user = getByKey(id);
        /*if(user!=null){
            Hibernate.initialize(user.getUserProfiles());
        }*/
        return user;
    }

    @Override
    public User findBySSO(String sso) {
        System.out.println("SSO : "+sso);
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("ssoId", sso));
        User user = (User)crit.uniqueResult();
        /*if(user!=null){
            Hibernate.initialize(user.getUserProfiles());
        }*/
        return user;
    }

    @Override
    public void save(User user) {
        persist(user);
    }

    @Override
    public void deleteBySSO(String sso) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("ssoId", sso));
        User user = (User)crit.uniqueResult();
        delete(user);
    }

    @Override
    public List<User> findAllUsers() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("firstName"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<User> users = (List<User>) criteria.list();

        // No need to fetch userProfiles since we are not showing them on list page. Let them lazy load.
        // Uncomment below lines for eagerly fetching of userProfiles if you want.
        /*
        for(User user : users){
            Hibernate.initialize(user.getUserProfiles());
        }*/
        return users;
    }
}
