package com.javazhiyin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import java.util.Map;

/**
 * Created by 57783 on 2018/7/4.
 */
@RestController
public class UserInfoController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 查
     * @return
     */
    @GetMapping(value = "/list")
    public List<Map<String, Object>> getUserList(){
        String sql = "select * from user_info";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        return list;
    }

    /**
     * 增
     * @param username
     * @param password
     * @return
     */
    @PostMapping(value = "/addUser")
    public String addUser(@RequestParam("username") String username,
                            @RequestParam("password") String password){

        String sql = "insert into user_info (username,password) value (?,?)";
        Object args[] = {username,password};
        int temp = jdbcTemplate.update(sql, args);

        if(temp > 0) {
            return "新增成功";
        }
        return "新增失败";
    }

    /**
     * 改
     * @param id
     * @param username
     * @param password
     * @return
     */
    @PutMapping(value = "updUser/{id}")
    public UserInfo updUser(@PathVariable("id") Integer id,
                        @RequestParam("username") String username,
                        @RequestParam("password") String password){

        String sql = "update user_info set username = ?,password = ? where id = ?";
        Object args[] = {username,password,id};
        int temp = jdbcTemplate.update(sql, args);
        UserInfo user = new UserInfo();
        if(temp > 0) {
            user.setId(id);
            user.setUsername(username);
            user.setPassword(password);
            return user;
        }
        return user;

    }

    /**
     * 删
     * @param id
     */
    @DeleteMapping(value = "delUser/{id}")
    public String delUser(@PathVariable("id") Integer id){
        UserInfo user = new UserInfo();
        user.setId(id);
        String sql = "delete from user_info where id = ?";
        Object args[] = {id};
        int temp = jdbcTemplate.update(sql, args);
        if(temp > 0) {
            return "删除成功";
        }
        return "删除出现错误";

    }

}
