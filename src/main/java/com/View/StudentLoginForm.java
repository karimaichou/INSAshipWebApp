package com.View;

import java.io.Serializable;

/**
 * Created by karima on 14/11/2016.
 */
public class StudentLoginForm implements Serializable {

    private String username;

    private String password;

    private boolean remember;

    public boolean isRemember() {
        return remember;
    }

    public void setRemember(boolean remember) {
        this.remember = remember;
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
}
