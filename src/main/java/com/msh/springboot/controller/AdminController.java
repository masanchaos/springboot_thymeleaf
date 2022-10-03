package com.msh.springboot.controller;

import com.msh.springboot.bean.Admin;
import com.msh.springboot.bean.User;
import com.msh.springboot.service.AdminService;
import com.msh.springboot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class AdminController {

    @Resource
    AdminService adminService;

    @Resource
    UserService userService;

    @PostMapping("/login")
    //Model作用,request域信息傳遞
    public String login(Admin admin, HttpSession session , Model model){
        Admin loginAdmin = adminService.adminCheck(admin);
        //驗證數據是否合法
        if (loginAdmin != null){
            //把登錄成功的管理員保存起来
            session.setAttribute("loginAdmin", loginAdmin);
            //合法，就重定向到manage.html(這是映射路徑)
            return "redirect:/manage.html";
        }else {
            model.addAttribute("msg", "賬號/密碼錯誤");
            //不合法就重新登錄(默認是請求轉發)
            return "adminLogin";
        }

    }
    @GetMapping("/manage.html")
    public String mainPage(HttpSession session,Model model) {

            List<User> users = userService.listUsers();
            //將數據放入request域,供前端渲染
            model.addAttribute("users", users);
            return "manage";

    }
}
