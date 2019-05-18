package com.example.hirecar.controller;


import com.example.hirecar.PDO.UserCachePDO;
import com.example.hirecar.bean.Release;
import com.example.hirecar.bean.User;
import com.example.hirecar.param.LoginParam;

import com.example.hirecar.param.RegisterParam;
import com.example.hirecar.service.UserService;
import com.example.hirecar.util.Response;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Response login(@RequestBody LoginParam loginParam) {
        UserCachePDO userCachePDO = userService.sureLogin(loginParam);

        if(userCachePDO == null) {
            return new Response(400,"用户名或密码错误");
        } else {
            return new Response(userCachePDO);
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

    @GetMapping("/typeList")
    public Response<List> typeList(@RequestBody Map<String,Object> params) {
       List list = userService.typeList(params.get("type").toString(),Integer.parseInt(params.get("userId").toString()));
        System.out.println(list);
        return new Response(list);

    }


}
