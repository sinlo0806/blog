package com.example.demo.service;

import com.example.demo.po.User;
import org.springframework.stereotype.Service;

@Service
public interface UserMapperService {
    boolean userIsExist(User user) throws Exception;;
}
