package com.bjsxt.registeration.service;

import com.bjsxt.registeration.model.User;

import java.sql.SQLException;

/**
 * Created by  Mark L Tao on 2016/7/27 16:33.
 */
public interface UserManager {
    boolean exists(User u) throws SQLException;

    void add(User user) throws SQLException;
}
