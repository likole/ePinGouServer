package cn.likole.dao;

import cn.likole.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * Created by likole on 4/14/2017.
 */
@Repository
public class UserDAO extends HibernateDaoSupport {

    @Autowired
    UserDAO(SessionFactory sessionFactory)
    {
        super.setSessionFactory(sessionFactory);
    }


    public void add(User user) {
        this.getHibernateTemplate().save(user);
    }
}
