package com.example.hirecar.service.impl;

import com.example.hirecar.bean.User;
import com.example.hirecar.mapper.UserMapper;
import com.example.hirecar.param.LoginParam;
import com.example.hirecar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User sureLogin(LoginParam loginParam) {
        return userMapper.getByAccountPasswd(loginParam);
    }
}
