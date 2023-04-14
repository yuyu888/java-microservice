package com.myproject.demoservice.api.controller;

import com.myproject.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/test")
public class TestController {
 
    @RequestMapping("/")
    public R hello(){
        return R.ok().put("data","hello word");
    }

}