package com.atdc.spring05.controller;

import com.atdc.spring05.mapper.UserMapper;
import com.atdc.spring05.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@ResponseBody
public class UserController {
    @Autowired
    private UserMapper userMapper;
//    List<User> queryUserList();
//    User queryUserById(String uid);
//    int addUser();
//    int updateUser();
//    int deleteUser();

    @GetMapping("/queryUserList")
    public  List<User> queryUserList(){
        List<User> users = userMapper.queryUserList();
        for(User user:users){
            System.out.println(user);
        }
        return users;
    }
    @GetMapping("/addUser")
    public User addUser(){
        User user = new User("搜索", 55);
        userMapper.addUser(user);
        return user;
    }
}
