package com.bjsxt.registeration.service;

import com.bjsxt.registeration.model.User;
import com.bjsxt.registeration.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.*;

/**
 * Created by Mark on 2016/7/24.
 */
public class UserManager {
    public boolean exists(User u) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Long count = (Long)    session.createQuery("select count (*) from User u where u.username = :username").setString("username",u.getUsername()).uniqueResult();
        session.getTransaction().commit();
        if(count>0) return true;
        return false;

    }

    public void add(User user) throws SQLException {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();

    }
}
