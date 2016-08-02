package com.bjsxt.registeration.action;

import com.bjsxt.registeration.model.User;
import com.bjsxt.registeration.service.UserManager;
import com.bjsxt.registeration.service.impl.UserManagerImpl;
import com.bjsxt.registeration.vo.UserRegisterInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by  Mark L Tao on 2016/7/27 17:58.
 */

public class UserAction extends ActionSupport implements ModelDriven {
    private String username;
    private String password;
    private UserManager userManager;
    private List<User> users;
    private  User user;
    private UserRegisterInfo userRegisterInfo = new UserRegisterInfo();

    public  UserAction(){

        System.out.println("new......");

    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public UserRegisterInfo getUserRegisterInfo() {
        return userRegisterInfo;
    }

    public void setUserRegisterInfo(UserRegisterInfo userRegisterInfo) {
        this.userRegisterInfo = userRegisterInfo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserManager getUserManager() {
        return userManager;
    }

    @Autowired
    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    public String execute() throws Exception {
        User user = new User();
        user.setUsername(userRegisterInfo.getUsername());
        user.setPassword(userRegisterInfo.getPassword());
        if (userManager.exists(user)) {
            return "fail";
        }
        userManager.add(user);
        return "success";
    }

    public String list() throws Exception {
        this.users = this.userManager.getUsers();
        return "list";
    }

    public  String load(){
        this.user = this.userManager.loadById(userRegisterInfo.getId());
        return "load";
    }


    public Object getModel() {
        return userRegisterInfo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
