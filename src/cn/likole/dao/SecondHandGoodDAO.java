package cn.likole.dao;

import cn.likole.entity.SecondHandGood;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by likole on 5/30/2017.
 */
@Repository
public class SecondHandGoodDAO extends HibernateDaoSupport{

    @Autowired
    SecondHandGoodDAO(SessionFactory sessionFactory)
    {
        super.setSessionFactory(sessionFactory);
    }

    void add(SecondHandGood secondHandGood)
    {
        this.getHibernateTemplate().save(secondHandGood);
    }

    public List<SecondHandGood> getList(int off, int limit) {
        List<SecondHandGood> list=this.getHibernateTemplate().execute(new HibernateCallback<List<SecondHandGood>>() {
            @Override
            public List<SecondHandGood> doInHibernate(Session session) throws HibernateException {
                org.hibernate.query.Query query=session.createQuery("from SecondHandGood  where sold=0 order by gid desc");
                query.setFirstResult(off);
                query.setMaxResults(limit);
                List<SecondHandGood> tlist=query.list();
                return tlist;
            }
        });
       if(list.size()==0)
           return null;
       else return list;
    }
}
