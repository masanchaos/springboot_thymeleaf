package com.msh.springboot.mapper;

import com.msh.springboot.bean.Admin;
import org.apache.ibatis.annotations.Mapper;

/**
 * Author: JeffMa
 */
@Mapper
public interface AdminMapper {
    public Admin adminCheck(Admin admin);
}
