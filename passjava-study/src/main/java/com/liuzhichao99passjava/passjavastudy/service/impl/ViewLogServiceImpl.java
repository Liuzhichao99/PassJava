package com.liuzhichao99passjava.passjavastudy.service.impl;

import com.liuzhichao99.common.utils.PageUtils;
import com.liuzhichao99.common.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.liuzhichao99passjava.passjavastudy.dao.ViewLogDao;
import com.liuzhichao99passjava.passjavastudy.entity.ViewLogEntity;
import com.liuzhichao99passjava.passjavastudy.service.ViewLogService;


@Service("viewLogService")
public class ViewLogServiceImpl extends ServiceImpl<ViewLogDao, ViewLogEntity> implements ViewLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ViewLogEntity> page = this.page(
                new Query<ViewLogEntity>().getPage(params),
                new QueryWrapper<ViewLogEntity>()
        );

        return new PageUtils(page);
    }

}