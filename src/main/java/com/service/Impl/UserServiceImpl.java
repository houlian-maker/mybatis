package com.service.Impl;

import com.entity.User;
import com.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserMapper{
    @Autowired
    UserMapper userMapper;

    @Override
    public User Sel(int id) {
        return userMapper.Sel(id);
    }
}
