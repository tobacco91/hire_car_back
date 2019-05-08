package com.example.hirecar.service;

import com.example.hirecar.bean.User;

import com.example.hirecar.param.LoginParam;

public interface UserService {
    User sureLogin(LoginParam loginParam);
}
