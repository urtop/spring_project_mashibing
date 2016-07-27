package com.bjsxt.registeration.service;

import com.bjsxt.registeration.model.User;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by  Mark L Tao on 2016/7/26 10:27.
 */
public class UserManagerTest {
    @Test
    public void exists() throws Exception {
        UserManager userManager = new UserManager();
        User user = new User();
        user.setUsername("aaa");
        boolean exists = userManager.exists(user);
        Assert.assertEquals(true, exists);
    }

    @Test
    public void add() throws Exception {

    }

}