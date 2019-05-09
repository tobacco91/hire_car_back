package com.example.hirecar.controller;

import com.example.hirecar.bean.User;
import com.example.hirecar.param.LoginParam;

import com.example.hirecar.param.RegisterParam;
import com.example.hirecar.service.UserService;
import com.example.hirecar.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Response login(@RequestBody LoginParam loginParam) {
        User user = userService.sureLogin(loginParam);

        if(user == null) {
            return new Response(400,"用户名或密码错误");
        } else {
            return new Response(200,"登录成功");
        }
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public  Response register(RegisterParam registerParam) {
        int row = userService.register(registerParam);
        if(row == -1) {
            return new Response(400,"账号已存在");
        } else if(row == 1) {
            return new Response(200,"注册成功");
        } else {
            return new Response(500,"注册失败");
        }
    }

}
