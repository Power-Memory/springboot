package com.javazhiyin.dao;

import com.javazhiyin.entity.User;

import java.util.List;

/**
 * Created by 57783 on 2018/7/6.
 */
public interface UserDao {

    List<User> findAll();

    void addUser(User user);

    void updUser(User user);

    int delUser(Integer id);



}