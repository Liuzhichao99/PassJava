package com.liuzhichao99passjava.passjavacontent.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liuzhichao99.common.utils.PageUtils;

import com.liuzhichao99passjava.passjavacontent.entity.BannerEntity;

import java.util.Map;

/**
 * 内容-横幅广告表
 *
 * @author liuzhichao99
 * @email 7823628@qq.com
 * @date 2022-06-23 03:44:31
 */
public interface BannerService extends IService<BannerEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

