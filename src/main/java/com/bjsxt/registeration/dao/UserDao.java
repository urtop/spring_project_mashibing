package com.bjsxt.registeration.dao;

import com.bjsxt.registeration.model.User;

import java.util.List;

/**
 * Created by  Mark L Tao on 2016/7/27 14:50.
 */
public interface UserDao {
    public void save(User user);
    public boolean checkUserExistWithName(String username);
    public  List<User> getUsers();
    public User loadById(int id);

}
