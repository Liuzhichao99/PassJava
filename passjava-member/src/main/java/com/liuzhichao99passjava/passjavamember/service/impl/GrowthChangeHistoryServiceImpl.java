package com.liuzhichao99passjava.passjavamember.service.impl;

import com.liuzhichao99.common.utils.PageUtils;
import com.liuzhichao99.common.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.liuzhichao99passjava.passjavamember.dao.GrowthChangeHistoryDao;
import com.liuzhichao99passjava.passjavamember.entity.GrowthChangeHistoryEntity;
import com.liuzhichao99passjava.passjavamember.service.GrowthChangeHistoryService;


@Service("growthChangeHistoryService")
public class GrowthChangeHistoryServiceImpl extends ServiceImpl<GrowthChangeHistoryDao, GrowthChangeHistoryEntity> implements GrowthChangeHistoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GrowthChangeHistoryEntity> page = this.page(
                new Query<GrowthChangeHistoryEntity>().getPage(params),
                new QueryWrapper<GrowthChangeHistoryEntity>()
        );

        return new PageUtils(page);
    }

}