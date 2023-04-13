package com.myproject.models.testservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myproject.common.utils.PageUtils;
import com.myproject.common.utils.Query;
import com.myproject.datesource.annotation.DataSource;
import com.myproject.models.testservice.dao.LogDao;
import com.myproject.models.testservice.entity.LogEntity;
import com.myproject.models.testservice.form.LogPageForm;
import com.myproject.models.testservice.service.LogService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Service("logService")
@DataSource("mytest")
public class LogServiceImpl extends ServiceImpl<LogDao, LogEntity> implements LogService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper<LogEntity> queryWrapper = new QueryWrapper<LogEntity>();
        //需要倒序的时候，放开下面的注释，并使用合适的排序字段
        //queryWrapper.orderByDesc("id");

        IPage<LogEntity> page = this.page(
                new Query<LogEntity>().getPage(params),
                queryWrapper
        );
        return new PageUtils(page);
//        PageUtils pageData = new PageUtils(page);
//        List<UserPrizeRecordsEntity> newlist = (List<UserPrizeRecordsEntity>) pageData.getList();
//        return new PageUtils(newlist, pageData.getTotalCount(), pageData.getPageSize(), pageData.getCurrPage());
    }

    @Override
    public PageUtils queryPage(LogPageForm pageForm) {

        LogEntity entity = new LogEntity();
        QueryWrapper<LogEntity> queryWrapper = new QueryWrapper<>(entity);
        //需要倒序的时候，放开下面的注释，并使用合适的排序字段
        queryWrapper.orderByDesc("id");

        IPage<LogEntity> page = this.page(
                new Query<LogEntity>().getPage(pageForm.getPageMap()),
                queryWrapper
        );

        return new PageUtils(page);
    }

    @Override
    public List<LogEntity> getListByUid(Integer uid) {
        return baseMapper.getListByUid(uid);
    }

    @Override
    public void insertBatch(List<LogEntity> dataList) {
        baseMapper.insertBatch(dataList);
    }

    /**
     * 在多数据源情况下，如果直接在Controller中使用IService接口中的方法，会发生数据源匹配错误的情况<br>
     * 因此，需要在XxxxServiceImple 中重新覆盖IService接口中的同名方法。
     */
    @Override
    public LogEntity getOne(Wrapper<LogEntity> queryWrapper) {
        return super.getOne(queryWrapper);
    }

    /**
     * 在多数据源情况下，如果直接在Controller中使用IService接口中的方法，会发生数据源匹配错误的情况<br>
     * 因此，需要在XxxxServiceImple 中重新覆盖IService接口中的同名方法。
     */
    @Override
    public LogEntity getById(Serializable id) {
        return super.getById(id);
    }


    /**
     * 在多数据源情况下，如果直接在Controller中使用IService接口中的方法，会发生数据源匹配错误的情况<br>
     * 因此，需要在XxxxServiceImple 中重新覆盖IService接口中的同名方法。
     */
    @Override
    public List<LogEntity> list(Wrapper<LogEntity> queryWrapper) {
        return super.list(queryWrapper);
    }

    /**
     * 在多数据源情况下，如果直接在Controller中使用IService接口中的方法，会发生数据源匹配错误的情况<br>
     * 因此，需要在XxxxServiceImple 中重新覆盖IService接口中的同名方法。
     */
    @Override
    public boolean save(LogEntity entity) {
        return super.save(entity);
    }

    /**
     * 在多数据源情况下，如果直接在Controller中使用IService接口中的方法，会发生数据源匹配错误的情况<br>
     * 因此，需要在XxxxServiceImple 中重新覆盖IService接口中的同名方法。
     */
    @Override
    public boolean updateById(LogEntity entity) {
        return super.updateById(entity);
    }


    /**
     * 在多数据源情况下，如果直接在Controller中使用IService接口中的方法，会发生数据源匹配错误的情况<br>
     * 因此，需要在XxxxServiceImple 中重新覆盖IService接口中的同名方法。
     */
    //@Override
    //public boolean removeByIds(Collection<? extends Serializable> idList) {
    //    return super.removeByIds(idList);
    //}


//    @Override
//    public boolean logicDeleteById(Integer id) {
//        UserPrizeRecordsEntity entity = new UserPrizeRecordsEntity();
//        //请根据各自实际情况进行逻辑删除
//		entity.setId(id);
//		entity.setStatus(2);
//        return super.updateById(entity);
//    }
}
