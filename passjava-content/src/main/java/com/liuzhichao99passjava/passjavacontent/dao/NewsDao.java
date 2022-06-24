package com.liuzhichao99passjava.passjavacontent.dao;

import com.liuzhichao99passjava.passjavacontent.entity.NewsEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 内容-资讯表
 * 
 * @author liuzhichao99
 * @email 7823628@qq.com
 * @date 2022-06-23 03:44:31
 */
@Mapper
public interface NewsDao extends BaseMapper<NewsEntity> {
	
}
