package com.liuzhichao99passjava.passjavaquestion.controller;

import com.liuzhichao99.common.utils.PageUtils;
import com.liuzhichao99.common.utils.R;
import com.liuzhichao99passjava.passjavaquestion.entity.QuestionEntity;
import com.liuzhichao99passjava.passjavaquestion.service.QuestionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 
 *
 * @author liuzhichao99
 * @email 7823628@qq.com
 * @date 2022-06-22 18:54:05
 */
@RestController
@RequestMapping("passjavaquestion/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("passjavaquestion:question:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = questionService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("passjavaquestion:question:info")
    public R info(@PathVariable("id") Long id){
		QuestionEntity question = questionService.getById(id);

        return R.ok().put("question", question);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("passjavaquestion:question:save")
    public R save(@RequestBody QuestionEntity question){
		questionService.save(question);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("passjavaquestion:question:update")
    public R update(@RequestBody QuestionEntity question){
		questionService.updateById(question);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("passjavaquestion:question:delete")
    public R delete(@RequestBody Long[] ids){
		questionService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
