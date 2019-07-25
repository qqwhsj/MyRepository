package com.woniuxy.service;

import com.woniuxy.entity.Msg;
import com.woniuxy.entity.PageBean;
import com.woniuxy.entity.Users;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    Users loginIn();
    void usersRegister(Msg msg, Users users);
//    PageBean findMsgByPage(int index);
    Msg findMsgByMid(String mid);
    Users findUserByUid(String uid);
    int updateMsg(Msg msg);
    void deleteUser(String mid);
    PageBean findPageBeanByFuzzy(int index,String mname,int age);
    Users findUsersByUsername(String username);
}
