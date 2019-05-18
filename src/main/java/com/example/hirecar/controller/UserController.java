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


        String a = "111";
        System.out.println(this.getCrc(a.getBytes())+ "绝望脸");
        System.out.println(this.getCrc("22222222".getBytes())+ "绝望脸");
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

    private String getCrc(byte[] data) {
        int high;
        int flag;

        // 16位寄存器，所有数位均为1
        int wcrc = 0xffff;
        for (int i = 0; i < data.length; i++) {
            // 16 位寄存器的高位字节
            high = wcrc >> 8;
            // 取被校验串的一个字节与 16 位寄存器的高位字节进行“异或”运算
            wcrc = high ^ data[i];

            for (int j = 0; j < 8; j++) {
                flag = wcrc & 0x0001;
                // 把这个 16 寄存器向右移一位
                wcrc = wcrc >> 1;
                // 若向右(标记位)移出的数位是 1,则生成多项式 1010 0000 0000 0001 和这个寄存器进行“异或”运算
                if (flag == 1)
                    wcrc ^= 0xa001;
            }
        }

        return Integer.toHexString(wcrc);
    }


}
