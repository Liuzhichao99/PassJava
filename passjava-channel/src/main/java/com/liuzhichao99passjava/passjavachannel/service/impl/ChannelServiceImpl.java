package com.liuzhichao99passjava.passjavachannel.service.impl;

import com.liuzhichao99.common.utils.PageUtils;
import com.liuzhichao99.common.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.liuzhichao99passjava.passjavachannel.dao.ChannelDao;
import com.liuzhichao99passjava.passjavachannel.entity.ChannelEntity;
import com.liuzhichao99passjava.passjavachannel.service.ChannelService;


@Service("channelService")
public class ChannelServiceImpl extends ServiceImpl<ChannelDao, ChannelEntity> implements ChannelService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ChannelEntity> page = this.page(
                new Query<ChannelEntity>().getPage(params),
                new QueryWrapper<ChannelEntity>()
        );

        return new PageUtils(page);
    }

}