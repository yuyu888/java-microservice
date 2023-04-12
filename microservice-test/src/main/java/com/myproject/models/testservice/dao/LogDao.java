package com.myproject.models.testservice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myproject.models.testservice.entity.LogEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LogDao extends BaseMapper<LogEntity> {

    @Select("SELECT * FROM log WHERE uid = #{uid} AND operate_type = #{operateType} LIMIT 1")
    LogEntity getOneByUid(@Param("uid") Integer uid, @Param("operateType") Integer operateType);

    @Select("SELECT * FROM log WHERE uid = #{uid}")
    List<LogEntity> getListByUid(Integer uid);

    List<LogEntity> getListByIds(@Param("ids")  List<Integer> ids);

    void  insertBatch(@Param("datalist")  List<LogEntity> datalist);

}