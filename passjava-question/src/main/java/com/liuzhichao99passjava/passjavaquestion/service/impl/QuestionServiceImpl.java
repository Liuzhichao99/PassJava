package com.liuzhichao99passjava.passjavaquestion.service.impl;

import com.liuzhichao99.common.utils.PageUtils;
import com.liuzhichao99.common.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.liuzhichao99passjava.passjavaquestion.dao.QuestionDao;
import com.liuzhichao99passjava.passjavaquestion.entity.QuestionEntity;
import com.liuzhichao99passjava.passjavaquestion.service.QuestionService;


@Service("questionService")
public class QuestionServiceImpl extends ServiceImpl<QuestionDao, QuestionEntity> implements QuestionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<QuestionEntity> page = this.page(
                new Query<QuestionEntity>().getPage(params),
                new QueryWrapper<QuestionEntity>()
        );

        return new PageUtils(page);
    }

}