package com.liuzhichao99passjava.passjavastudy.dao;

import com.liuzhichao99passjava.passjavastudy.entity.ViewLogEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 学习-用户学习浏览记录表
 * 
 * @author liuzhichao99
 * @email 7823628@qq.com
 * @date 2022-06-23 03:51:13
 */
@Mapper
public interface ViewLogDao extends BaseMapper<ViewLogEntity> {
	
}
