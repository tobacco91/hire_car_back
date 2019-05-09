package com.example.hirecar.mapper;

import com.example.hirecar.bean.User;
import com.example.hirecar.param.LoginParam;
import com.example.hirecar.param.RegisterParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User getByAccountPasswd(LoginParam loginParam);

    User selectAccount(@Param("account") String account);
    int addUser(User user);
}
