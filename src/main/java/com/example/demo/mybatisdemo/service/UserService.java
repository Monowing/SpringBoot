package com.example.demo.mybatisdemo.service;


import com.example.demo.mybatisdemo.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    List<User> findByName(String name);

    List<User> findByNameAndPassword(User user);
}