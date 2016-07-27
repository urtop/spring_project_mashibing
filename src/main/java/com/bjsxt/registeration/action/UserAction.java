package com.bjsxt.registeration.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by  Mark L Tao on 2016/7/27 17:58.
 */
public class UserAction extends ActionSupport {
    private String username;
    private String password;

    @Override
    public String execute() throws Exception {
        return "success";
    }
}
