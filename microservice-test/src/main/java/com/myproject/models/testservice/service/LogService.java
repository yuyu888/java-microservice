package com.myproject.models.testservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myproject.common.utils.PageUtils;
import com.myproject.models.testservice.entity.LogEntity;

import java.util.List;
import java.util.Map;

public interface LogService extends IService<LogEntity> {
    PageUtils queryPage(Map<String, Object> params);

    List<LogEntity> getListByUid(Integer openId);

    void insertBatch(List<LogEntity> dataList);
}
