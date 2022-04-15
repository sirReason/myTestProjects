package com.aop.service;

import java.util.List;

public interface UserService {

    /**
     * 模拟保存用户
     */
    void saveUser(User user);

    /**
     * 批量保存用户
     */
    void saveAllUser(List<User> users);
}