package com.woniuxy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniuxy.entity.Msg;
import com.woniuxy.entity.PageBean;
import com.woniuxy.entity.Users;
import com.woniuxy.exception.UserException;
import com.woniuxy.service.UserService;
import com.woniuxy.test.EncodeUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class UserController {
    @Autowired
    UserService userServiceImpl;

    @RequestMapping("/register.do")
    public ModelAndView register(HttpServletRequest request, Msg msg, Users users) {
        ModelAndView mv = new ModelAndView();
        //错误信息
        Map exMsg = new HashMap();
//        姓名判断
        System.out.println(msg.getMname().equals(""));
        if (msg.getMname() == null || msg.getMname().equals("")) {
            System.out.println("jinru");
            exMsg.put("mnameEx", "姓名不可为空");
        } else if (msg.getMname().length() > 6) {
            exMsg.put("mnameEx", "姓名不可大于6位");
        }
//        年龄判断
        if (msg.getAge() == null) {
            exMsg.put("ageEx", "年龄不可为空");
        } else if (msg.getAge() < 0 && msg.getAge() > 100) {
            exMsg.put("ageEx", "请输出真实年龄");
        }
        //手机号验证
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        if (msg.getMobile() == "" || msg.getMobile().trim() == "") {
            exMsg.put("mobileEx", "手机号不可为空");
        } else if (msg.getMobile().length() != 11) {
            exMsg.put("mobileEx", "手机号长度应为11位");
        } else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(msg.getMobile());
            boolean isMatch = m.matches();
            if (!isMatch) {
                exMsg.put("mobileEx", "手机号格式错误");
            }
        }
        //邮箱号验证
        if (msg.getEmail() == "" || msg.getEmail().trim() == "") {
            exMsg.put("emailEx", "邮箱不可为空");
        } else {
            regex = "[a-zA-Z_]{0,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(msg.getEmail());
            boolean isMatch = m.matches();
            if (!isMatch) {
                exMsg.put("emailEx", "邮箱格式错误");
            }
        }
        System.out.println(exMsg.size());
        System.out.println(exMsg.toString());
//        身份证格式验证
        if (exMsg.size() > 0) {
            mv.addObject("exMsg", exMsg);
            mv.setViewName("/system/addUser.jsp");
            return mv;
        }
        try {
            userServiceImpl.usersRegister(msg, users);
        } catch (Exception e) {
            e.printStackTrace();
            mv.addObject("sqlEx", e.getMessage());
            mv.setViewName("/system/addUser.jsp");
            System.out.println("执行失败");
            return mv;
        }
        System.out.println("执行成功");
        return new ModelAndView("/userList.do");
    }

    @RequestMapping("/userList.do")
    public ModelAndView userList(HttpServletRequest request) {
        String str = request.getParameter("index");
        int index;
        if (str == "" || str == null) {
            index = 1;
        } else {
            index = Integer.parseInt(str);
        }
        String mname = request.getParameter("newMname");
        try {
            if(mname!=null) {
                String encoding = EncodeUtils.getEncoding(mname);
                if(encoding=="ISO-8859-1") {
                    mname = new String(mname.getBytes(encoding), "utf-8");
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        int age = 0;
        String ageStr = request.getParameter("newAge");
        if (ageStr != null && ageStr != "") {
            age = Integer.parseInt(ageStr);
        }
        PageBean msgByPage = userServiceImpl.findPageBeanByFuzzy(index, mname, age);
        System.out.println("mname=" + mname);
        System.out.println("age=" + age);
        ModelAndView mv = new ModelAndView();
        mv.addObject("msgPage", msgByPage);
        mv.addObject("newMname", mname);
        mv.addObject("newAge", age);
        mv.setViewName("/system/userList.jsp");
        Subject subject = SecurityUtils.getSubject();
        System.out.println(subject.getPrincipal());
        return mv;
    }

    @RequestMapping("/userInfo.do")
    public ModelAndView userInfo(HttpServletRequest request) {
        String mid = request.getParameter("mid");
        Msg msg = userServiceImpl.findMsgByMid(mid);
        Users user = userServiceImpl.findUserByUid(msg.getUid());
        ModelAndView mv = new ModelAndView();
        mv.addObject("msgIndex", msg);
        mv.addObject("username", user.getUsername());
        mv.setViewName("/system/userInfo.jsp");
        return mv;
    }

    //    修改跳转页面
    @RequestMapping("/userInfoUpdate.do")
    public ModelAndView userInfoUpdate(HttpServletRequest request) {
        String mid = request.getParameter("mid");
        Msg msg = userServiceImpl.findMsgByMid(mid);
        Users user = userServiceImpl.findUserByUid(msg.getUid());
        ModelAndView mv = new ModelAndView();
        mv.addObject("msgIndex", msg);
        mv.addObject("username", user.getUsername());
        mv.addObject("methodUpdate", "update");
        mv.setViewName("/system/userInfo.jsp");
        return mv;
    }

    @RequestMapping("/updateMsg.do")
    public ModelAndView updateMsg(HttpServletRequest request, Msg msg, String username) {
        ModelAndView mv = new ModelAndView();
        //错误信息
        Map exMsg = new HashMap();
//        姓名判断
        System.out.println(msg.getMname().equals(""));
        if (msg.getMname() == null || msg.getMname().equals("")) {
            System.out.println("jinru");
            exMsg.put("mnameEx", "姓名不可为空");
        } else if (msg.getMname().length() > 6) {
            exMsg.put("mnameEx", "姓名不可大于6位");
        }
//        年龄判断
        if (msg.getAge() == null) {
            exMsg.put("ageEx", "年龄不可为空");
        } else if (msg.getAge() < 0 && msg.getAge() > 100) {
            exMsg.put("ageEx", "请输出真实年龄");
        }
        //手机号验证
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        if (msg.getMobile() == "" || msg.getMobile().trim() == "") {
            exMsg.put("mobileEx", "手机号不可为空");
        } else if (msg.getMobile().length() != 11) {
            exMsg.put("mobileEx", "手机号长度应为11位");
        } else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(msg.getMobile());
            boolean isMatch = m.matches();
            if (!isMatch) {
                exMsg.put("mobileEx", "手机号格式错误");
            }
        }
        //邮箱号验证
        if (msg.getEmail() == "" || msg.getEmail().trim() == "") {
            exMsg.put("emailEx", "邮箱不可为空");
        } else {
            regex = "[a-zA-Z_]{0,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(msg.getEmail());
            boolean isMatch = m.matches();
            if (!isMatch) {
                exMsg.put("emailEx", "邮箱格式错误");
            }
        }
        System.out.println(exMsg);
        System.out.println(username);
//        身份证格式验证
        if (exMsg.size() > 0) {
            mv.addObject("msgIndex", msg);
            mv.addObject("exMsg", exMsg);
            mv.addObject("username", username);
            mv.addObject("methodUpdate", "update");
            mv.setViewName("/system/userInfo.jsp");
            return mv;
        }
        int i = userServiceImpl.updateMsg(msg);
//        if(i==0){
//            throw new UserException("")
//        }
//        PageBean msgPage = userServiceImpl.findMsgByPage(1);
        mv.setViewName("/userList.do");
        return mv;
    }

    //    删除功能，ajax.返回值会自动转化为json(js中确定是json)
    @RequestMapping("/deleteUser.do")
    @ResponseBody
    public String deleteUser(String mid, HttpServletRequest request) {
        try {
            userServiceImpl.deleteUser(mid);
            System.out.println("删除成功");
            PageBean msgByPage = userServiceImpl.findPageBeanByFuzzy(1, null, 0);
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(msgByPage);
//            request.setAttribute("msgPage",msgByPage);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //    模糊查询
    @RequestMapping("/findFuzzy.do")
    public ModelAndView findFuzzy(String mname, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        System.out.println("mname==" + mname);
        int age = 0;
        String str = request.getParameter("age");
        System.out.println(str);
        if (str != null && str != "") {
            age = Integer.parseInt(str);
        }
        System.out.println("age== " + age);
        if ((mname == null || mname == "") && age == 0) {
            System.out.println("两个值为空");
            mv.setViewName("/userList.do");
            return mv;
        }
        PageBean msgPage = userServiceImpl.findPageBeanByFuzzy(1, mname, age);
        mv.addObject("msgPage", msgPage);
        mv.setViewName("/system/userList.jsp");
        return mv;
    }
}
