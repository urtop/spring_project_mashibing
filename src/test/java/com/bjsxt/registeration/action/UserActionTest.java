package com.bjsxt.registeration.action;

import com.bjsxt.registeration.vo.UserRegisterInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Time;
import java.util.Calendar;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Mark on 2016/7/30.
 */
public class UserActionTest {
    @Test
    public void execute() throws Exception {
        UserAction userAction = new UserAction();
        UserRegisterInfo info = new UserRegisterInfo();
        info.setPassword("1");
        info.setUsername("89898");
        userAction.setUserRegisterInfo(info);
        String ret = userAction.execute();
        assertEquals("success", ret);
    }

    @Test
    public void testList() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        UserAction userAction = (UserAction) applicationContext.getBean("user");
        userAction.list();
        Assert.assertTrue(userAction.getUsers().size()>0);

    }

    @Test
    public void testLoad() throws Exception{

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        UserAction userAction = (UserAction) applicationContext.getBean("user");
        UserRegisterInfo info = new UserRegisterInfo();
        info.setId(1);
        userAction.load();
        Assert.assertTrue(userAction.getUser()!=null);

    }
}