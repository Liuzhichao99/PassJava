package com.liuzhichao99passjava.passjavaquestion.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liuzhichao99.common.utils.PageUtils;

import com.liuzhichao99passjava.passjavaquestion.entity.TypeEntity;

import java.util.Map;

/**
 * 题目-题目类型表
 *
 * @author liuzhichao99
 * @email 7823628@qq.com
 * @date 2022-06-22 18:54:05
 */
public interface TypeService extends IService<TypeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

