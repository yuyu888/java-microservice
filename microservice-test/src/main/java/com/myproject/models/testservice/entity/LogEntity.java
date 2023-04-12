package com.myproject.models.testservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
@TableName("log")
public class LogEntity {
    @TableId(type = IdType.AUTO)
    private Integer id;

    @JsonProperty("uid")
    private Integer uid;

    @JsonProperty("operate_type")
    private Integer operateType;

    @JsonProperty("opeate_detail")
    private String opeateDetail;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("create_time")
    private Date createTime;

    /**
     * 扩展属性
     */
    @TableField(exist = false)
    @JsonProperty("extra_field_map")
    private Map<String,String> extraFieldMap;


}