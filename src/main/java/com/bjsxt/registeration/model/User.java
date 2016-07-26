package com.bjsxt.registeration.model;

import com.bjsxt.registeration.service.UserManager;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.SQLException;

/**
 * Created by Mark on 2016/7/24.
 */
@Entity
public class User {
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

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String username;
    private String password;
    private int id;

}
