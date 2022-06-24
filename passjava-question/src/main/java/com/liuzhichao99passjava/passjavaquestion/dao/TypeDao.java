package com.liuzhichao99passjava.passjavaquestion.dao;

import com.liuzhichao99passjava.passjavaquestion.entity.TypeEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 题目-题目类型表
 * 
 * @author liuzhichao99
 * @email 7823628@qq.com
 * @date 2022-06-22 18:54:05
 */
@Mapper
public interface TypeDao extends BaseMapper<TypeEntity> {
	
}
