package com.example.demo.mapper;


import com.example.demo.po.User;

public interface UserMapper {
  User userIsExist(User user) throws Exception;;
}