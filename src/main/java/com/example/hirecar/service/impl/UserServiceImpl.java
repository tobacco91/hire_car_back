package com.example.hirecar.service.impl;

import com.example.hirecar.PDO.UserCachePDO;
import com.example.hirecar.bean.Buy;
import com.example.hirecar.bean.Collect;
import com.example.hirecar.bean.Release;
import com.example.hirecar.bean.User;
import com.example.hirecar.mapper.BuyMapper;
import com.example.hirecar.mapper.CollectMapper;
import com.example.hirecar.mapper.ReleaseMapper;
import com.example.hirecar.mapper.UserMapper;
import com.example.hirecar.param.LoginParam;
import com.example.hirecar.param.RegisterParam;
import com.example.hirecar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BuyMapper buyMapper;
    @Autowired
    private CollectMapper collectMapper;
    @Autowired
    private ReleaseMapper releaseMapper;

    @Override
    public User sureLogin(LoginParam loginParam) {
        User user = userMapper.getByAccountPasswd(loginParam);
        if(user == null) {
            return null;
        } else {
            UserCachePDO userCachePDO = new UserCachePDO();
            userCachePDO.setUserId(user.getUserId());
            userCachePDO.setToken(
                    UUID.randomUUID().toString().replace("-", "")
            );
            this.addCatche(userCachePDO);
            return user;
        }
    }

    @Override
    @Cacheable(value="userInfoCatche", key="#userInfo.userId")
    public UserCachePDO addCatche(UserCachePDO userCachePDO) {
        return userCachePDO;
    }

    @Override
    public int register(RegisterParam registerParam) {
        User user = userMapper.selectAccount(registerParam.getAccount());
        if(user != null) {
            return -1;
        } else {
            //获取原始文件名
            String originalFilename = registerParam.getAvatar().getOriginalFilename();
            String defaultPath = "/Users/mac/Desktop/avatarImage/";
            String path = defaultPath + Math.random() + originalFilename;
            File dest = new File(path);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                registerParam.getAvatar().transferTo(dest);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            User param = new User(registerParam.getAccount()
                    ,path,registerParam.getPassword(),
                    registerParam.getName());
            int row = userMapper.addUser(param);
            return row;
        }

    }

    @Override
    public List typeList(String type, int userId) {
        switch (type) {
            case "release":
                List<Release> list = releaseMapper.getList(userId);

                return list;
            case "buy":
                List<Buy> buyList = buyMapper.getList(userId);
                return buyList;
            case "collect":
                List<Collect> collectList = collectMapper.getList(userId);
                return collectList;
        }
        return null;
    }


}
