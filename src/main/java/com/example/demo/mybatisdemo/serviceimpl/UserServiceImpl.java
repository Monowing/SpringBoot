package com.example.demo.mybatisdemo.serviceimpl;

import com.example.demo.mybatisdemo.entity.User;
import com.example.demo.mybatisdemo.mapper.UserMapper;
import com.example.demo.mybatisdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public List<User> findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public List<User> findByNameAndPassword(User user) {
        return userMapper.findByNameAndPassword(user);
    }
}