package com.liuzhichao99passjava.passjavaquestion.service.impl;

import com.liuzhichao99.common.utils.PageUtils;
import com.liuzhichao99.common.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.liuzhichao99passjava.passjavaquestion.dao.TypeDao;
import com.liuzhichao99passjava.passjavaquestion.entity.TypeEntity;
import com.liuzhichao99passjava.passjavaquestion.service.TypeService;


@Service("typeService")
public class TypeServiceImpl extends ServiceImpl<TypeDao, TypeEntity> implements TypeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TypeEntity> page = this.page(
                new Query<TypeEntity>().getPage(params),
                new QueryWrapper<TypeEntity>()
        );

        return new PageUtils(page);
    }

}