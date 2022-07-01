package com.liuzhichao99passjava.passjavasearch.controller;

import com.liuzhichao99.common.exception.BizCodeEnum;
import com.liuzhichao99.common.to.es.QuestionEsModel;
import com.liuzhichao99.common.utils.R;
import com.liuzhichao99passjava.passjavasearch.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/search")
@RestController
public class QuestionController {

    @Autowired
    IQuestionService questionService;

    // 保存题目到 ES。
    @PostMapping("/question/save")
    public R saveQuestion(@RequestBody QuestionEsModel questionEsModel) {
        boolean result =false;
        try {
            result = questionService.save(questionEsModel);
        } catch (Exception e) {
            result =false;
        }

        if (!result) {
            return R.error(BizCodeEnum.QUESTION_SAVE_EXCEPTION.getCode(), BizCodeEnum.QUESTION_SAVE_EXCEPTION.getMsg());
        }

        return R.ok();
    }
}
