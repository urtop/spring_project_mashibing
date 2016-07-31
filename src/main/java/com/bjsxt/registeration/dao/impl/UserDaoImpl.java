package com.bjsxt.registeration.dao.impl;

import com.bjsxt.registeration.dao.UserDao;
import com.bjsxt.registeration.model.User;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by  Mark L Tao on 2016/7/27 15:49.
 */

@Component
public class UserDaoImpl implements UserDao {
    private HibernateTemplate hibernateTemplate;

    public void save(User user) {
        hibernateTemplate.save(user);
    }

    public boolean checkUserExistWithName(String username) {
        List<User> users = hibernateTemplate.find("from User u where u.username ='" + username + "'");
        if (users != null && users.size() > 0) {
            return true;
        }
        return false;

    }

    public List<User> getUsers() {
        return  (List<User>)  this.hibernateTemplate.find("from User");
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Resource
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
