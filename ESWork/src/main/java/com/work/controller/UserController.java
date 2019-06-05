package com.work.controller;

import com.work.entity.User;
import com.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhourui
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index(){
        return "Hello";
    }
    @RequestMapping("/saveOrUpdateUser")
    public String saveOrUpdateUser(Long id, String name, String motto, Integer age) {
        return userService.saveOrUpdateUser(id, name, motto, age);
    }
    @PostMapping("/scrollQueryUser")
    public List<User> scrollQueryUser(String name) {
        return userService.scrollQueryUser(name);
    }



}
