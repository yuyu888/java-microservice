package com.myproject.demoservice.api.controller;

import com.myproject.common.utils.R;
import com.myproject.feignapi.test.ServiceAPiTestServiceTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/test")
public class TestController {
    @Autowired
    private ServiceAPiTestServiceTest serviceAPiTestServiceTest;
 
    @RequestMapping("/hello")
    public R hello(){
        return R.ok().put("data","hello word");
    }

    @RequestMapping("/feignapi-test")
    public R feignApiTest(){
        return R.ok().put("data", serviceAPiTestServiceTest.feignApiTest());
    }

}