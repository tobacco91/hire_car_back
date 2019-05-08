package com.example.hirecar.mapper;

import com.example.hirecar.bean.User;
import com.example.hirecar.param.LoginParam;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User getByAccountPasswd(LoginParam loginParam);
}
