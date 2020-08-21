package com.example.demo.mybatisdemo.mapper;

import com.example.demo.mybatisdemo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> findAll();

    List<User> findByName(String name);

    List<User> findByNameAndPassword(User user);
}
