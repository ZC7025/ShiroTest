package com.zc.common;

import org.apache.shiro.authc.UsernamePasswordToken;

public class CustomerLoginToken extends UsernamePasswordToken {
    private static final long serialVersionUID = 2020457391511655213L;

    private String loginType;

    public CustomerLoginToken() {}

    public CustomerLoginToken(String loginType) {
        this.loginType = loginType;
    }

    public CustomerLoginToken(String username, char[] password, String loginType) {
        super(username, password);
        this.loginType = loginType;
    }

    public CustomerLoginToken(String username, String password, String loginType) {
        super(username, password);
        this.loginType = loginType;
    }

    public CustomerLoginToken(String username, char[] password, String host, String loginType) {
        super(username, password, host);
        this.loginType = loginType;
    }

    public CustomerLoginToken(String username, String password, String host, String loginType) {
        super(username, password, host);
        this.loginType = loginType;
    }

    public CustomerLoginToken(String username, char[] password, boolean rememberMe, String loginType) {
        super(username, password, rememberMe);
        this.loginType = loginType;
    }

    public CustomerLoginToken(String username, String password, boolean rememberMe, String loginType) {
        super(username, password, rememberMe);
        this.loginType = loginType;
    }

    public CustomerLoginToken(String username, char[] password, boolean rememberMe, String host, String loginType) {
        super(username, password, rememberMe, host);
        this.loginType = loginType;
    }

    public CustomerLoginToken(String username, String password, boolean rememberMe, String host, String loginType) {
        super(username, password, rememberMe, host);
        this.loginType = loginType;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }
}
