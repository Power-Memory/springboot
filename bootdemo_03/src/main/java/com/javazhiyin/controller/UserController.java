package com.javazhiyin.controller;

import com.javazhiyin.entity.User;
import com.javazhiyin.service.UserService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 57783 on 2018/7/6.
 */
@RestController
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/showUser")
    public List<User> getUser(){
        List<User> user = this.userService.getUser();
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
        userService.addUser(user);
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
        userService.updUser(user);

    }

    @DeleteMapping(value = "delUser/{id}")
    public void delUser(@PathVariable("id") Integer id){
        userService.delUser(id);
    }




}
