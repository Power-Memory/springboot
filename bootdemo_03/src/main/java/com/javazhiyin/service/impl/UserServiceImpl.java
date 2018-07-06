package com.javazhiyin.service.impl;

import com.javazhiyin.dao.UserDao;
import com.javazhiyin.entity.User;
import com.javazhiyin.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 57783 on 2018/7/6.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;


    public List<User> getUser() {
        return userDao.findAll();
    }

    public void addUser(User user){
        userDao.addUser(user);
    }

    public void updUser(User user){
        userDao.updUser(user);
    }

    public int delUser(Integer id){
        return userDao.delUser(id);
    }

}
