package com.liuzhichao99passjava.passjavastudy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liuzhichao99.common.utils.PageUtils;

import com.liuzhichao99passjava.passjavastudy.entity.ViewLogEntity;

import java.util.Map;

/**
 * 学习-用户学习浏览记录表
 *
 * @author liuzhichao99
 * @email 7823628@qq.com
 * @date 2022-06-23 03:51:13
 */
public interface ViewLogService extends IService<ViewLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

