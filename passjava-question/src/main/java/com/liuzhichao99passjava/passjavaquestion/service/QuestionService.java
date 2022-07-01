package com.liuzhichao99passjava.passjavaquestion.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.liuzhichao99.common.utils.PageUtils;

import com.liuzhichao99passjava.passjavaquestion.entity.QuestionEntity;

import java.util.Map;

/**
 * 
 *
 * @author liuzhichao99
 * @email 7823628@qq.com
 * @date 2022-06-22 18:54:05
 */
public interface QuestionService extends IService<QuestionEntity> {

    PageUtils queryPage(Map<String, Object> params);

    QuestionEntity info(Long id);

    boolean saveQuestion(QuestionEntity question);

    boolean updateQuestion(QuestionEntity question);

    QuestionEntity createQuestion(QuestionEntity question);
}

