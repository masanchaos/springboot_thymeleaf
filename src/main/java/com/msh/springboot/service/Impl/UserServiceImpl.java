package com.msh.springboot.service.Impl;

import com.msh.springboot.bean.User;
import com.msh.springboot.mapper.UserMapper;
import com.msh.springboot.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author: JeffMa
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public List<User> listUsers() {
        List<User> users = userMapper.listUsers();
        return users;
    }
}
