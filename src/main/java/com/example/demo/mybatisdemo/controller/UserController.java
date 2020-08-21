package com.example.demo.mybatisdemo.controller;

import com.example.demo.mybatisdemo.entity.User;
import com.example.demo.mybatisdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("like")
    public List<User> findLike() {
        String name = "%clg%";
        return userService.findByName(name);
    }

    @GetMapping("one")
    public List<User> findOne() {
        User user = new User();
        user.setUsername("clg");
        user.setPassword("123456");
        return userService.findByNameAndPassword(user);
    }
}
