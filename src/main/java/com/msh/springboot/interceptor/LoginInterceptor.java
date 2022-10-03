package com.msh.springboot.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//攔截器(要註冊)
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    //目標方法執行前調用
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        log.info("攔截到的URI={}",requestURI);
        HttpSession session = request.getSession();
        Object loginAdmin = session.getAttribute("loginAdmin");
        if (null!=loginAdmin){ //成功登錄
            return true;
        }else {
            request.setAttribute("msg","你沒有登錄,請重新登錄");
            //被攔截，返回登錄頁面
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }
    }

    //目標方法執行完執行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("posthandle執行了");
    }
    //完全處理完請求後被調用，可以進行資源清理
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion執行了");

    }
}
