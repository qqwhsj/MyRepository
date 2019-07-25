package com.woniuxy.dao;

import com.woniuxy.entity.Sign;
import com.woniuxy.entity.SignExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SignMapper {
    int countByExample(SignExample example);

    int deleteByExample(SignExample example);

    int deleteByPrimaryKey(String sid);

    int insert(Sign record);

    int insertSelective(Sign record);

    List<Sign> selectByExample(SignExample example);

    Sign selectByPrimaryKey(String sid);

    int updateByExampleSelective(@Param("record") Sign record, @Param("example") SignExample example);

    int updateByExample(@Param("record") Sign record, @Param("example") SignExample example);

    int updateByPrimaryKeySelective(Sign record);

    int updateByPrimaryKey(Sign record);

    int findSignCount(@Param("signIn") String signIn,@Param("signOut") String signOut);

    List<Sign> findPageBeanByFuzzy(@Param("msgIndex") int index, @Param("size") int size,@Param("signIn") String signIn,@Param("signOut") String signOut);

    int updateSignOut(@Param("signOut") String signOut);
}