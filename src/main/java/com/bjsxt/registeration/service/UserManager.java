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


//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        Connection conn = null;
//        try {
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/spring", "root", "");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        String sql_check = "SELECT count(*) FROM user WHERE username=? ";
//        PreparedStatement ps_check = null;
//        try {
//            ps_check = conn.prepareStatement(sql_check);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        ps_check.setString(1, u.getUsername());
//        ResultSet rs = ps_check.executeQuery();
//        rs.next();
//        int count = rs.getInt(1);
//        conn.close();
//        ps_check.close();
//        if (count > 0) {
//            return true;
//        }
        return false;
    }

    public void add(User user) throws SQLException {

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/spring", "root", "");
        String sql = "INSERT INTO user VALUES(NULL,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        ps.executeUpdate();
        ps.close();
        conn.close();
    }
}
