package com.woniuxy.service;

import com.woniuxy.entity.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SignService {

    int insertSignIn(String ip);

    PageBean findPageBeanByFuzzy(int index, String signIn, String signOut);

    int insertSignOut(String ip);
//    offTime表
    OffTime findOffTime();

    int updateOffTime(OffTime offTime);

    PageBean findAllOvertime(int index, int size, String oname);

    //    overtime表
    int updateOvertime(Overtime overtime);
}
