package com.woniuxy.controller;

import com.woniuxy.entity.Users;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.woniuxy.service.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyController {
    @Autowired
    UserService userServiceImpl;
    @Autowired
    DefaultWebSecurityManager securityManager;
    @Autowired
    Users users;
//    @RequestMapping("/test.do")
//    public void test01(){
//        System.out.println("进入test.do");
//        Users users=new Users();
//        users.setUsername("111");
//        users.setPassword("123");
//        users.setSalt("salt");
//        int a=usersServiceImpl.insUser(users);
//        System.out.println("int==="+a);
//    }

    @RequestMapping("/login.do")
    public ModelAndView login(HttpServletRequest request) {
//        String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
//        ModelAndView mv = new ModelAndView();
//        if (exceptionClassName != null) {
//            if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
//                mv.addObject("msg", "账号不存在");
//            } else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
//                mv.addObject("msg", "密码错误");
//            } else if ("randomCodeError".equals(exceptionClassName)) {
//                mv.addObject("msg", "验证码错误");
//            } else {
//                mv.addObject("msg", "未知错误");
//            }
//        }
//        System.out.println("1111=========="+exceptionClassName);
//        mv.setViewName("/login.jsp");
//        return mv;

//        return null;
        System.out.println("shuru");
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken("root","123"));
            System.out.println("登录成功");
            return new ModelAndView("/system/index/index.html");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println("登录失败");
            System.out.println("登录失败");
            System.out.println("登录失败");
        }
        return new ModelAndView("login.jsp");
    }
}
