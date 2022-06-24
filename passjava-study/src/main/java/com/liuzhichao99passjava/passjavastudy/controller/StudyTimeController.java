package com.liuzhichao99passjava.passjavastudy.controller;

import com.liuzhichao99.common.utils.PageUtils;
import com.liuzhichao99.common.utils.R;
import com.liuzhichao99passjava.passjavastudy.entity.StudyTimeEntity;
import com.liuzhichao99passjava.passjavastudy.service.StudyTimeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 学习-用户学习时常表
 *
 * @author liuzhichao99
 * @email 7823628@qq.com
 * @date 2022-06-23 03:51:13
 */
@RestController
@RequestMapping("passjavastudy/studytime")
public class StudyTimeController {
    @Autowired
    private StudyTimeService studyTimeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("passjavastudy:studytime:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = studyTimeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("passjavastudy:studytime:info")
    public R info(@PathVariable("id") Long id){
		StudyTimeEntity studyTime = studyTimeService.getById(id);

        return R.ok().put("studyTime", studyTime);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("passjavastudy:studytime:save")
    public R save(@RequestBody StudyTimeEntity studyTime){
		studyTimeService.save(studyTime);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("passjavastudy:studytime:update")
    public R update(@RequestBody StudyTimeEntity studyTime){
		studyTimeService.updateById(studyTime);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("passjavastudy:studytime:delete")
    public R delete(@RequestBody Long[] ids){
		studyTimeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    //返回某个用户学习题目的总时长
    @RequestMapping("/member/list/test/{id}")
    public R memberStudyTimeTest(@PathVariable("id") Long id) {
        StudyTimeEntity studyTimeEntity = new StudyTimeEntity();
        studyTimeEntity.setTotalTime(100); // 学习时长：100分钟
        studyTimeEntity.setQuesType(1L); // 题目类型：1 （javaBasic）

        return R.ok().put("studytime", Arrays.asList(studyTimeEntity));
    }

}
