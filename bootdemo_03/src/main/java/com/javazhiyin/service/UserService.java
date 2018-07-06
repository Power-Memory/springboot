package com.javazhiyin.service;

import com.javazhiyin.entity.User;

import java.util.List;

/**
 * Created by 57783 on 2018/7/6.
 */
public interface UserService {
    List<User> getUser();

    void addUser(User user);

    void updUser(User user);

    int delUser(Integer id);

}