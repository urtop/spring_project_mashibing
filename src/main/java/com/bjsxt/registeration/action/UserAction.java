package com.bjsxt.registeration.action;

import com.bjsxt.registeration.model.User;
import com.bjsxt.registeration.service.UserManager;
import com.bjsxt.registeration.service.impl.UserManagerImpl;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by  Mark L Tao on 2016/7/27 17:58.
 */
public class UserAction extends ActionSupport {
    private String username;
    private String password;

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

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    private UserManager userManager = new UserManagerImpl();

    @Override
    public String execute() throws Exception {
        User user =new User();
        user.setUsername(username);
        user.setPassword(password);
        if(userManager.exists(user)){
            return "fail";
        }
        userManager.add(user);
        return "success";
    }
}
