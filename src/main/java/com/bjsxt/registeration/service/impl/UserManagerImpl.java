package com.bjsxt.registeration.service.impl;

import com.bjsxt.registeration.dao.UserDao;
import com.bjsxt.registeration.dao.impl.UserDaoImpl;
import com.bjsxt.registeration.model.User;
import com.bjsxt.registeration.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Mark on 2016/7/24.
 */

@Component
public class UserManagerImpl implements UserManager {
    private UserDao userDao;

    public boolean exists(User u) throws SQLException {
        return userDao.checkUserExistWithName(u.getUsername());
    }

    public void add(User user) throws SQLException {
        userDao.save(user);
    }

    public List<User> getUsers() {
        return userDao.getUsers();
    }

    public User loadById(int id) {
        return userDao.loadById(id);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
