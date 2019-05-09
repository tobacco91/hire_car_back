package com.example.hirecar.bean;

public class User {

    private String account;
    private String avatarPath;
    private String password;
    private String name;
    private Integer userId;

    public User(String account, String avatarPath, String password, String name) {
        this.account = account;
        this.avatarPath = avatarPath;
        this.password = password;
        this.name = name;

    }

    public Integer getUserId() {
        return userId;
    }


    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccount() {
        return account;
    }


    public void setPassword(String password) {
        this.password = password;
    }



    public String getPassword() {
        return password;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }
}
