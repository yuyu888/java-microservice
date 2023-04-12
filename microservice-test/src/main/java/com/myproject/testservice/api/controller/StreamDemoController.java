package com.myproject.testservice.api.controller;

import com.myproject.testservice.dto.PersonDto;
import com.myproject.testservice.api.logic.StreamDemoLogic;
import com.myproject.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/stream-demo")
public class StreamDemoController {
    @Autowired
    StreamDemoLogic streamDemoLogic;

    @GetMapping("/list-to-map")
    public R listToMap(){
        Map<String, PersonDto> res =  streamDemoLogic.listToMap();
        return R.ok().put("data",res);
    }

    @RequestMapping("/list-to-list")
    public R listToList(){
        List<Integer> res =  streamDemoLogic.listToList();
        return R.ok().put("data",res);
    }

    @RequestMapping("/list-count")
    public R listCount(){
        long res =  streamDemoLogic.listCount();
        return R.ok().put("data",res);
    }

    @RequestMapping("/list-sum")
    public R listSum(){
        long res =  streamDemoLogic.listSumAge();
        return R.ok().put("data",res);
    }

    @RequestMapping("/list-filter")
    public R listFilter(){
        List<PersonDto> res =  streamDemoLogic.listFilter();
        return R.ok().put("data",res);
    }

    @RequestMapping("/map-to-list")
    public R mapToList(){
        List<PersonDto> res =  streamDemoLogic.mapToList();
        return R.ok().put("data",res);
    }

    @RequestMapping("/list-foreach")
    public R listForeach(){
        List<String> res =  streamDemoLogic.listForeach();
        return R.ok().put("data",res);
    }
}
