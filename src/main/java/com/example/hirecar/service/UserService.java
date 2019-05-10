package com.example.hirecar.service;

import com.example.hirecar.bean.Release;
import com.example.hirecar.bean.User;

import com.example.hirecar.param.LoginParam;
import com.example.hirecar.param.RegisterParam;

import java.util.List;

public interface UserService {
    User sureLogin(LoginParam loginParam);
    int register(RegisterParam registerParam);

    List typeList(String type, Integer userId);
}
