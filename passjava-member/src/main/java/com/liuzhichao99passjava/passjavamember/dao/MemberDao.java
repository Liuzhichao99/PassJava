package com.liuzhichao99passjava.passjavamember.dao;

import com.liuzhichao99passjava.passjavamember.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员-会员表
 * 
 * @author liuzhichao99
 * @email 7823628@qq.com
 * @date 2022-06-23 03:48:31
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
