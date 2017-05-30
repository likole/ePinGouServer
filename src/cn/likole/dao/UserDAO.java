package cn.likole.dao;

import cn.likole.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by likole on 4/14/2017.
 */
@Repository
public class UserDAO extends HibernateDaoSupport {

    @Autowired
    UserDAO(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }


    public void add(User user) {
        this.getHibernateTemplate().save(user);
    }

    public User getByPhone(String phone) {
        List<User> list = (List<User>) this.getHibernateTemplate().find("from User where phone = ?", phone);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public User getByPhoneAndPassword(String phone, String password) {
        List<User> list = (List<User>) this.getHibernateTemplate().find("from User where phone=? and password=?", phone, password);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}
