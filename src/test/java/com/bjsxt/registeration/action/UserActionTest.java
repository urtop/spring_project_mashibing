package com.bjsxt.registeration.action;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Mark on 2016/7/30.
 */
public class UserActionTest {
    @Test
    public void execute() throws Exception {
        UserAction userAction = new UserAction();
        userAction.setUsername("new2");
        userAction.setPassword("newpp");
        String ret = userAction.execute();
        assertEquals("success", ret);
    }

}