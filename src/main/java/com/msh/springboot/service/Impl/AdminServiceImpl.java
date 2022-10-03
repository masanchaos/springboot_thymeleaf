package com.msh.springboot.service.Impl;

import com.msh.springboot.bean.Admin;
import com.msh.springboot.mapper.AdminMapper;
import com.msh.springboot.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Author: JeffMa
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    AdminMapper adminMapper;

    @Override
    public Admin adminCheck(Admin admin) {
        Admin loginAdmin = adminMapper.adminCheck(admin);
        return loginAdmin;
    }
}
