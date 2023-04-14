package com.myproject.demoservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class PersonDto {
    private Integer uid;
    private String name;
    private Integer age;
    private BigDecimal weight;
    private String sex;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;

}