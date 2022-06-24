package com.liuzhichao99passjava.passjavamember.dao;

import com.liuzhichao99passjava.passjavamember.entity.GrowthChangeHistoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员-积分值变化历史记录表
 * 
 * @author liuzhichao99
 * @email 7823628@qq.com
 * @date 2022-06-23 03:48:31
 */
@Mapper
public interface GrowthChangeHistoryDao extends BaseMapper<GrowthChangeHistoryEntity> {
	
}
