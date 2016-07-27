package com.bjsxt.registeration.dao.impl;

import com.bjsxt.registeration.dao.UserDao;
import com.bjsxt.registeration.model.User;
import com.bjsxt.registeration.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by  Mark L Tao on 2016/7/27 15:49.
 */
public class UserDaoImpl implements UserDao{

    public void save(User user) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }

    public boolean checkUserExistWithName(String username) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Long count = (Long) session.createQuery("select count (*) from User u where u.username = :username").setString("username", username).uniqueResult();
        session.getTransaction().commit();
        if (count > 0) return true;
        return false;

    }
}
