package com.javazhiyin.controller;

import com.javazhiyin.dao.UserMapper;
import com.javazhiyin.entity.User;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/**
 * Created by 57783 on 2018/7/6.
 */
@RestController
public class UserController {
    @Resource
    private UserMapper userMapper;

    @GetMapping("/showUser/{id}")
    public User getUser(@PathVariable("id") Integer id){
        User user = this.userMapper.selectByPrimaryKey(id);
        return user;
    }

    @PostMapping(value = "/addUser")
    public void addUser(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam("age") Integer age){
        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        user.setAge(age);
        userMapper.insert(user);
    }

    @PutMapping(value = "updUser/{id}")
    public void updUser(@PathVariable("id") Integer id,
                        @RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam("age") Integer age){
        User user = new User();
        user.setId(id);
        user.setUserName(username);
        user.setPassword(password);
        user.setAge(age);
        userMapper.updateByPrimaryKey(user);

    }

    @DeleteMapping(value = "delUser/{id}")
    public void delUser(@PathVariable("id") Integer id){
        userMapper.deleteByPrimaryKey(id);
    }

}
