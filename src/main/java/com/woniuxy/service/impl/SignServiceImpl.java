package com.woniuxy.service.impl;

import com.woniuxy.dao.OffTimeMapper;
import com.woniuxy.dao.OvertimeMapper;
import com.woniuxy.dao.SignMapper;
import com.woniuxy.dao.UsersMapper;
import com.woniuxy.entity.OffTime;
import com.woniuxy.entity.Overtime;
import com.woniuxy.entity.PageBean;
import com.woniuxy.entity.Sign;
import com.woniuxy.exception.SignException;
import com.woniuxy.service.SignService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class SignServiceImpl implements SignService {

    @Autowired
    SignMapper signMapper;
    @Autowired
    UsersMapper usersMapper;
    @Autowired
    OffTimeMapper offTimeMapper;
    @Autowired
    OvertimeMapper overtimeMapper;

    /**
     * 完成签到功能
     * @param ip 获取当前ip
     * @return  返回值为状态码
     */
    @Override
    public int insertSignIn(String ip) {
//        初始化sign对象
        Sign sign = new Sign();
//        获取当前用户的Username
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();
//        获取当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String signIn = df.format(new Date());
//        获取sid值
        String sid = username + signIn.substring(0, 10);
        Sign hasSign = signMapper.selectByPrimaryKey(sid);
        if (hasSign != null) {
//            当天已经签到,无法再次签到
            return 0;
        }
        sign.setSid(username + signIn.substring(0, 10));
        sign.setSname(usersMapper.findMnameByUsername(username));
        sign.setSignin(signIn);
        sign.setSignip(ip);
        System.out.println(sign);
        int insert = signMapper.insert(sign);
        if (insert == 1) {
//        签到成功
            return 1;
        }
//        发生未知错误
        return 2;
    }

    /**
     * 分页模糊查询
     * @param index 当前页
     * @param signIn 模糊查询签到部分
     * @param signOut 模糊查询签退部分
     * @return 返回当前页信息
     */
    @Override
    public PageBean findPageBeanByFuzzy(int index, String signIn, String signOut) {
        PageBean signPageBean=new PageBean();
        signPageBean.setPageSize(5);
        signPageBean.setPageIndex(index);
        int msgCount = signMapper.findSignCount(signIn,signOut);
        signPageBean.setTotalElm(msgCount);
        List<Sign> msgs = signMapper.findPageBeanByFuzzy((signPageBean.getPageIndex()-1) * signPageBean.getPageSize(), signPageBean.getPageSize(), signIn, signOut);
        System.out.println(msgs);
        signPageBean.setList(msgs);
        signPageBean.setBeginAndEndPage();
        signPageBean.setTotalPage();
        System.out.println(signPageBean);
        return signPageBean;
    }

    /**
     * 完成签退功能
     * @param ip 获得请求客户端的真实ip地址
     * @return 返回状态码
     */
    @Override
    public int insertSignOut(String ip) {
//        1.获取用户名
        Subject subject=SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();
//        2.获取当前日期
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String signOut=sdf.format(new Date());
        System.out.println(signOut);
        String sid=username+signOut.substring(0,10);
//        3.取出信息
        Sign sign = signMapper.selectByPrimaryKey(sid);
        if(sign==null){
//            请先完成签到操作在
            return 0;
        }
//        4.判断是否签退
        if(sign.getSignout()!=null && sign.getSignout().trim()==""){
//            当天已经签到,无法再次签到
            return 2;
        }
//        5.比对ip地址
        System.out.println("ip="+ip);
        System.out.println("signIp="+sign.getSignip());
        if(!sign.getSignip().equals(ip)){
//            请使用签到地址完成签退
            return 3;
        }
//        6.签退
        int result=signMapper.updateSignOut(signOut);
//        7.签退成功
        if(result==1){
            return 1;
        }else{
//            未知错误
            return 4;
        }

    }

    /**
     * 查找上班时间
     * @return
     */
    @Override
    public OffTime findOffTime() {
        try{
            OffTime offTime = offTimeMapper.findOffTime();
            return offTime;
        }catch (Exception e){
            throw new SignException("未知错误");
        }
    }

    /**
     * 修改上班时间
     * @param offTime
     * @return
     */
    @Override
    public int updateOffTime(OffTime offTime) {
        try{
            int i = offTimeMapper.updateOffTime(offTime);
            if(i==1){
                return 1;
            }else{
                return 0;
            }

        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 完成加班管理查询
     * @return
     */
    @Override
    public PageBean findAllOvertime(int index, int size, String oname){
        PageBean pageBean=new PageBean();
        pageBean.setPageIndex(index);
        pageBean.setPageSize(size);
        List list = null;
        int count=0;
        try {
            count=overtimeMapper.findCountOvertime();
            list = overtimeMapper.findAllOverTime((index-1)*size,size,oname);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SignException("查询异常");
        }
        pageBean.setTotalElm(count);
        pageBean.setList(list);
        pageBean.setTotalPage();
        pageBean.setBeginAndEndPage();
        return pageBean;
    }

    /**
     * 修改加班管理
     * @param overtime
     * @return
     */
    @Override
    public int updateOvertime(Overtime overtime){
        int result = 0;
        try {
            result = overtimeMapper.updateByPrimaryKey(overtime);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SignException("修改异常");
        }
        return result;
    }
}
