package com.myproject.testservice.api.controller;

import com.myproject.testservice.dto.PersonDto;
import com.myproject.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/test")
public class TestController {
 
    @RequestMapping("/")
    public R hello(){
        return R.ok().put("data","hello word");
    }

}