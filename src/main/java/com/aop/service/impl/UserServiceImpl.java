package com.aop.service.impl;

import com.aop.service.User;
import com.aop.service.UserService;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Override
    public void saveUser(User user) {
        System.out.println("执行了保存用户"+user);
    }

    @Override
    public void saveAllUser(List<User> users) {
        for(User user : users){
            UserService proxyUserServiceImpl = (UserService) AopContext.currentProxy();
            proxyUserServiceImpl.saveUser(user);
        }
    }
}