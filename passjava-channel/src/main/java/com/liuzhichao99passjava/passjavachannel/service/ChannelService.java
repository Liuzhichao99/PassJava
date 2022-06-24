package com.liuzhichao99passjava.passjavachannel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liuzhichao99.common.utils.PageUtils;

import com.liuzhichao99passjava.passjavachannel.entity.ChannelEntity;

import java.util.Map;

/**
 * 渠道-渠道表
 *
 * @author liuzhichao99
 * @email 7823628@qq.com
 * @date 2022-06-23 02:24:49
 */
public interface ChannelService extends IService<ChannelEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

