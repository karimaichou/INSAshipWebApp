package com.View;

import java.io.Serializable;

/**
 * Created by admin on 08/01/2017.
 */
public class ConfirmationForm implements Serializable {

    String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
