package com.example.demo.serviceImp;

import com.example.demo.mapper.UserMapper;
import com.example.demo.po.User;
import com.example.demo.service.UserMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapperServiceImp implements UserMapperService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public boolean userIsExist(User user) throws Exception {
        if(userMapper.userIsExist(user)==null) {
            return false;
        }
        return true;
    }
}
