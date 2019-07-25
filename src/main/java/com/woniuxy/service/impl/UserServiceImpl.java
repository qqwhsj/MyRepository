package com.woniuxy.service.impl;

import com.woniuxy.dao.MsgMapper;
import com.woniuxy.dao.UsersMapper;
import com.woniuxy.entity.Msg;
import com.woniuxy.entity.PageBean;
import com.woniuxy.entity.Users;
import com.woniuxy.exception.UserException;
import com.woniuxy.service.UserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    MsgMapper msgMapper;
    @Autowired
    UsersMapper usersMapper;
    @Autowired
    PageBean msgPageBean;
    @Override
    public Users loginIn() {
         return null;
    }
//    用户注册，数据验证未完成
    @Override
    public void usersRegister(Msg msg, Users users) {
        Users findUsers = usersMapper.findUserByUsername(users);
        if(findUsers!=null){
            throw new UserException("用户名已存在，请重新选择");
        }
        String uid= UUID.randomUUID().toString();
        uid=uid.replace("-","");
        users.setUid(uid);
        users.setSalt("salt");
        users.setPassword(new SimpleHash("MD5","123","salt",2).toString());
        users.setAvailable(1);
        System.out.println(users);
        int index1 = usersMapper.insert(users);
        if(index1==0){
            throw new UserException("用户注册失败，发生未知错误");
        }
        msg.setUid(uid);
        msg.setMid(UUID.randomUUID().toString().replace("-",""));
        System.out.println(msg);
        int index2 = msgMapper.insert(msg);
        if(index2==1){
            System.out.println("注册成功");
        }else{
            System.out.println("登录失败");
            throw new UserException("登录失败");
        }
    }
//    @Override
//    public PageBean findMsgByPage(int index) {
//        msgPageBean.setPageSize(5);
//        msgPageBean.setPageIndex(index);
//        int msgCount = msgMapper.findMsgCount();
//        msgPageBean.setTotalElm(msgCount);
//        List<Msg> msgs = msgMapper.findMsgByPage((msgPageBean.getPageIndex()-1) * msgPageBean.getPageSize(), msgPageBean.getPageSize());
//        msgPageBean.setList(msgs);
//        msgPageBean.setBeginAndEndPage();
//        msgPageBean.setTotalPage();
//        System.out.println(msgPageBean);
//        return msgPageBean;
//    }

    @Override
    public Msg findMsgByMid(String mid) {
        try {
            Msg msg = msgMapper.selectByPrimaryKey(mid);
            return msg;
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserException("发生未知错误，请联系管理员");
        }
    }

    @Override
    public Users findUserByUid(String uid) {
        try {
            Users user = usersMapper.selectByPrimaryKey(uid);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserException("发生未知错误，请联系管理员");
        }
    }

    @Override
    public int updateMsg(Msg msg) {
        int value = 0;
        try {
            value = msgMapper.updateByPrimaryKey(msg);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserException("修改失败，修改信息错误");
        }
    }

    @Override
    public void deleteUser(String mid) {
        try {
            Msg msg = msgMapper.selectByPrimaryKey(mid);
            msgMapper.deleteByPrimaryKey(mid);
            usersMapper.deleteByPrimaryKey(msg.getUid());
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserException("未知错误，请联系管理员");
        }
    }

    @Override
    public PageBean findPageBeanByFuzzy(int index, String mname, int age) {
        msgPageBean.setPageSize(5);
        msgPageBean.setPageIndex(index);
        int msgCount = msgMapper.findMsgCount(mname,age);
        msgPageBean.setTotalElm(msgCount);
        List<Msg> msgs = msgMapper.findPageBeanByFuzzy((msgPageBean.getPageIndex()-1) * msgPageBean.getPageSize(), msgPageBean.getPageSize(), mname, age);
        msgPageBean.setList(msgs);
        msgPageBean.setBeginAndEndPage();
        msgPageBean.setTotalPage();
        System.out.println(msgPageBean);
        return msgPageBean;
    }

    @Override
    public Users findUsersByUsername(String username) {
        Users users=new Users();
        users.setUsername(username);
        Users user = usersMapper.findUserByUsername(users);
        return user;
    }


}
