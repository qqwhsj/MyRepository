package com.woniuxy.controller;

import com.woniuxy.entity.OffTime;
import com.woniuxy.entity.PageBean;
import com.woniuxy.service.SignService;
import com.woniuxy.test.EncodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/sign")
public class SignController {
    @Autowired
    SignService signServiceImpl;

    /**
     * 签到信息查询
     * @param request
     * @return
     */
    @RequestMapping("/attendance.do")
    public ModelAndView attandance(HttpServletRequest request){
        String str = request.getParameter("index");
        int index;
        if (str == "" || str == null) {
            index = 1;
        } else {
            index = Integer.parseInt(str);
        }
        String signIn = request.getParameter("signIn");
        String signOut = request.getParameter("signOut");
        PageBean signPageBean = signServiceImpl.findPageBeanByFuzzy(index, signIn, signOut);
        System.out.println("mname=" + signIn);
        System.out.println("age=" + signOut);
        ModelAndView mv = new ModelAndView();
        System.out.println(signPageBean);
        mv.addObject("signPage", signPageBean);
        mv.addObject("signIn", signIn);
        mv.addObject("signOut", signOut);
        mv.setViewName("/system/attendance.jsp");
        return mv;
    }

    /**
     * 签到
     * @param request
     * @return
     */
    @RequestMapping("signIn.do")
    @ResponseBody
    public int signIn(HttpServletRequest request){
        System.out.println("进入signIn");
        String ip = EncodeUtils.getIp(request);
        int result = signServiceImpl.insertSignIn(ip);
        System.out.println("result为："+result);
        return result;
    }

    /**
     * 签退
     * @param request
     * @return
     */
    @RequestMapping("signOut.do")
    @ResponseBody
    public int signOut(HttpServletRequest request){
        System.out.println("进入signIn");
        String ip = EncodeUtils.getIp(request);
        int result = signServiceImpl.insertSignOut(ip);
        System.out.println("result为："+result);
        return result;
    }

    /**
     * 查找上班时间
     * @return
     */
    @RequestMapping("findOffTime.do")
    public ModelAndView findOffTime(){
        OffTime offTime = signServiceImpl.findOffTime();
        ModelAndView mv=new ModelAndView();
        mv.addObject("offTime",offTime);
        mv.setViewName("/system/attendanceSetting.jsp");
        return mv;
    }

    /**
     * 修改上班时间
     * @param offTime
     * @return
     */
    @RequestMapping("updateOffTime.do")
    public ModelAndView findOffTime(OffTime offTime){
        ModelAndView mv=new ModelAndView();
        Map msg=new HashMap();
        if(offTime.getOffBegin()==null || offTime.getOffBegin()=="" ){
            msg.put("offBeginEx","上班时间不可为空");
        }
        if(offTime.getNoonBegin()==null || offTime.getNoonBegin()=="" ){
            msg.put("noonBeginEx","午休开始不可为空");
        }
        if(offTime.getNoonOver()==null || offTime.getNoonOver()=="" ){
            msg.put("noonOverEx","午休结束不可为空");
        }
        if(offTime.getOffOver()==null || offTime.getOffOver()=="" ){
            msg.put("offOverEx","下班时间不可为空");
        }
        if(msg.size()>1){
             mv.addObject("offTimeEx",msg);
             mv.setViewName("/system/updateAttendanceSetting.jsp");
        }
        int result = signServiceImpl.updateOffTime(offTime);
        if(result==1){
            mv.setViewName("/sign/findOffTime.do");
            return mv;
        }
        mv.setViewName("/system/updateAttendanceSetting.jsp");
        return mv;
    }

    @RequestMapping("overtime.do")
    public ModelAndView overtime(HttpServletRequest request){
        String str = request.getParameter("index");
        int index;
        if (str == "" || str == null) {
            index = 1;
        } else {
            index = Integer.parseInt(str);
        }
        String oname=request.getParameter("oname");
        try {
            if(oname!=null) {
                String encoding = EncodeUtils.getEncoding(oname);
                if(encoding=="ISO-8859-1") {
                    oname = new String(oname.getBytes(encoding), "utf-8");
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("index="+index);
        System.out.println("size="+5);
        System.out.println("oname="+oname);
        PageBean overPage = signServiceImpl.findAllOvertime(index,5, oname);
        System.out.println(overPage);
        ModelAndView mv=new ModelAndView();
        mv.addObject("overPage",overPage);
        mv.setViewName("/system/overtime.jsp");
        return mv;
    }
}
