package com.bjsxt.registeration.service.impl;

import com.bjsxt.registeration.dao.UserDao;
import com.bjsxt.registeration.dao.impl.UserDaoImpl;
import com.bjsxt.registeration.model.User;
import com.bjsxt.registeration.service.UserManager;

import java.sql.SQLException;

/**
 * Created by Mark on 2016/7/24.
 */
public class UserManagerImpl implements UserManager {
    private UserDao userDao = new UserDaoImpl();

    public boolean exists(User u) throws SQLException {
        return userDao.checkUserExistWithName(u.getUsername());
    }

    public void add(User user) throws SQLException {
        userDao.save(user);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
