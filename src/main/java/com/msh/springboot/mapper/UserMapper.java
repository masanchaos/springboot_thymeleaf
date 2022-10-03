package com.msh.springboot.mapper;

import com.msh.springboot.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Author: JeffMa
 */
@Mapper
public interface UserMapper {
    public List<User> listUsers();
}
