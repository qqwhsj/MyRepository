package com.woniuxy.dao;

import com.woniuxy.entity.Msg;
import com.woniuxy.entity.MsgExample;
import com.woniuxy.entity.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MsgMapper {
    int findMsgCount(@Param("mname")String mname,@Param("age")int age);

    List<Msg> findMsgByPage(@Param("msgIndex") int index, @Param("size") int size);

    int countByExample(MsgExample example);

    int deleteByExample(MsgExample example);

    int deleteByPrimaryKey(String mid);

    int insert(Msg record);

    int insertSelective(Msg record);

    List<Msg> selectByExample(MsgExample example);

    Msg selectByPrimaryKey(String mid);

    int updateByExampleSelective(@Param("record") Msg record, @Param("example") MsgExample example);

    int updateByExample(@Param("record") Msg record, @Param("example") MsgExample example);

    int updateByPrimaryKeySelective(Msg record);

    int updateByPrimaryKey(Msg record);

    List findPageBeanByFuzzy(@Param("msgIndex") int index, @Param("size") int size, @Param("mname")String mname,@Param("age")int age);
}