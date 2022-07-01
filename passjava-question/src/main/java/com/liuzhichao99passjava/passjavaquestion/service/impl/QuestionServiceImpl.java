package com.liuzhichao99passjava.passjavaquestion.service.impl;

import com.liuzhichao99.common.to.es.QuestionEsModel;
import com.liuzhichao99.common.utils.PageUtils;
import com.liuzhichao99.common.utils.Query;
import com.liuzhichao99.common.utils.R;
import com.liuzhichao99passjava.passjavaquestion.entity.TypeEntity;
import com.liuzhichao99passjava.passjavaquestion.feign.SearchFeignService;
import com.liuzhichao99passjava.passjavaquestion.service.TypeService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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

    @Autowired
    TypeService typeService;

    @Autowired
    SearchFeignService searchFeignService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        //1.get key
        String key = (String) params.get("key");
        QueryWrapper<QuestionEntity> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(key)) {
            queryWrapper.eq("id", key).or().like("title", key).or().like("answer", key);
        }

        String type = (String) params.get("type");
        if (!StringUtils.isEmpty(type)) {
            queryWrapper.eq("type", type);
        }
        IPage<QuestionEntity> page = this.page(
                new Query<QuestionEntity>().getPage(params),
                queryWrapper
        );

        return new PageUtils(page);
    }

    @Override
    @Cacheable({"question", "hot"})
    public QuestionEntity info(Long id) {
        return getById(id);
    }

    @Override
    public boolean saveQuestion(QuestionEntity question) {
        boolean saveResult = save(question);
        //saveEs(question);

        return true;
    }

    @Override
    public boolean updateQuestion(QuestionEntity question) {
        updateById(question);
        //saveEs(question);

        return true;
    }

    @Override
    public QuestionEntity createQuestion(QuestionEntity question) {
        // Mock 返回 id
        question.setId(123L);
        return question;
    }

    private boolean saveEs(QuestionEntity question) {
        // 1.创建 ES model
        QuestionEsModel esModel = new QuestionEsModel();
        // 2.复制属性
        // 2.1 复制属性
        BeanUtils.copyProperties(question, esModel);
        // 2.2 获取“题目类型”的名称
        TypeEntity typeEntity = typeService.getById(question.getType());
        String typeName = typeEntity.getType();
        // 2.3 给 ES model 的“类型”字段赋值
        esModel.setTypeName(typeName);
        System.out.println("-----------------esModel:" + esModel);

        // 3. 调用 passjava-search 服务，将数据发送到 ES 中保存。
        R r = searchFeignService.saveQuestion(esModel);

        System.out.println("r:" + r);

        return true;
    }

}