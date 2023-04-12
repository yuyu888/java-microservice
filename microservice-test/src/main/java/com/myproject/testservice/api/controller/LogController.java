package com.myproject.testservice.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.testservice.api.logic.LogLogic;
import com.myproject.common.utils.R;
import com.myproject.models.testservice.entity.LogEntity;
import com.myproject.models.testservice.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/log")
public class LogController {
    @Autowired
    LogService logService;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    LogLogic logLogic;

    @RequestMapping("/{id}")
    public R getOne(@PathVariable("id") Integer id){
        LogEntity res =  logService.getById(id);
        return R.ok().put("data",res);
    }

    @RequestMapping("/get-list-by-uid")
    public R getListByUid(@RequestParam Map<String, Object> params){
        Integer uid = Integer.valueOf(String.valueOf(params.get("uid")));
        List<LogEntity> res =  logService.getListByUid(uid);
        return R.ok().put("data",res);
    }

    @PostMapping("/add")
    public R add(@RequestBody LogEntity logEntity){
        logService.save(logEntity);
        return R.ok().put("data", logEntity.getId());
    }

    @PostMapping("/create_post")
    public R createPost(@RequestBody Map<String, Object> params){
        String address = (String)params.get("address");
        Map<Integer, Integer> prizeRecordMap = objectMapper.convertValue(params.get("post_data"), Map.class);
        return R.ok();
    }

    @GetMapping("/export")
    public R export(@RequestParam Map<String, Object> params, HttpServletResponse response){
        logLogic.export(params, response);
        return null;
    }
}
