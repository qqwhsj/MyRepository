package com.woniuxy.dao;

import com.woniuxy.entity.OffTime;

public interface OffTimeMapper {
    int updateOffTime(OffTime offTime);
    OffTime findOffTime();
}
