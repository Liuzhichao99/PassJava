package com.liuzhichao99passjava.passjavamember.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liuzhichao99.common.utils.PageUtils;

import com.liuzhichao99passjava.passjavamember.entity.MemberEntity;

import java.util.Map;

/**
 * 会员-会员表
 *
 * @author liuzhichao99
 * @email 7823628@qq.com
 * @date 2022-06-23 03:48:31
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

