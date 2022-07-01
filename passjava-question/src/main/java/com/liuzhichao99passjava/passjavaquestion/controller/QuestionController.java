package com.liuzhichao99passjava.passjavaquestion.controller;

import com.liuzhichao99.common.utils.PageUtils;
import com.liuzhichao99.common.utils.R;
import com.liuzhichao99passjava.passjavaquestion.entity.QuestionEntity;
import com.liuzhichao99passjava.passjavaquestion.service.QuestionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * 
 *
 * @author liuzhichao99
 * @email 7823628@qq.com
 * @date 2022-06-22 18:54:05
 */
@RestController
@RequestMapping("question/v1/admin/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    /**
     * 测试方法的返回结果是否被缓存了
     */
    @RequestMapping("/test")
    @Cacheable(value = "hot", key = "#root.method.name")
    public int test() {
        return 222;
    }

    @RequestMapping("/test2")
    @Cacheable(value = "hot", key = "#root.method.name")
    public int test2() {
        return 456;
    }

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
    public R save(@Valid @RequestBody QuestionEntity question){
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


    @RequestMapping("/create")
    @CachePut(value = "hot", key = "#result.id")
    // mock create
    public QuestionEntity create(@Valid @RequestBody QuestionEntity question){
        return questionService.createQuestion(question);
    }

    @RequestMapping("/remove/{id}")
    @CacheEvict(value = "hot")
    public R remove(@PathVariable("id") Long id){
        questionService.removeById(id);
        return R.ok();
    }

    @RequestMapping("/condition/{id}")
    @Cacheable(value = "hot", unless = "#result.message.containss('NoCache')")
    public R condition(@PathVariable("id") Long id) {
        QuestionEntity question = questionService.info(id);
        HashMap<String, Object> map = new HashMap<String, Object>();

        return R.ok().put("question", question).put("message", "NoCache");
    }

}
