package com.liuzhichao99passjava.passjavachannel.dao;

import com.liuzhichao99passjava.passjavachannel.entity.AccessTokenEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 渠道-认证表
 * 
 * @author liuzhichao99
 * @email 7823628@qq.com
 * @date 2022-06-23 02:24:49
 */
@Mapper
public interface AccessTokenDao extends BaseMapper<AccessTokenEntity> {
	
}
