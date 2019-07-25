package com.woniuxy.dao;

import com.woniuxy.entity.Overtime;
import com.woniuxy.entity.OvertimeExample;
import com.woniuxy.entity.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OvertimeMapper {
    int findCountOvertime();

    List findAllOverTime(@Param("index")int index,@Param("size")int size,@Param("oname")String oname);

    int countByExample(OvertimeExample example);

    int deleteByExample(OvertimeExample example);

    int deleteByPrimaryKey(String oid);

    int insert(Overtime record);

    int insertSelective(Overtime record);

    List<Overtime> selectByExample(OvertimeExample example);

    Overtime selectByPrimaryKey(String oid);

    int updateByExampleSelective(@Param("record") Overtime record, @Param("example") OvertimeExample example);

    int updateByExample(@Param("record") Overtime record, @Param("example") OvertimeExample example);

    int updateByPrimaryKeySelective(Overtime record);

    int updateByPrimaryKey(Overtime record);

}