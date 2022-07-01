package com.liuzhichao99passjava.passjavaquestion.controller;

import com.liuzhichao99.common.utils.PageUtils;
import com.liuzhichao99.common.utils.R;
import com.liuzhichao99passjava.passjavaquestion.entity.TypeEntity;
import com.liuzhichao99passjava.passjavaquestion.service.TypeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 题目-题目类型表
 *
 * @author liuzhichao99
 * @email 7823628@qq.com
 * @date 2022-06-22 18:54:05
 */
@RestController
@RequestMapping("question/type")
public class TypeController {
    @Autowired
    private TypeService typeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("passjavaquestion:type:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = typeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("passjavaquestion:type:info")
    public R info(@PathVariable("id") Long id){
		TypeEntity type = typeService.getById(id);

        return R.ok().put("type", type);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("passjavaquestion:type:save")
    public R save(@RequestBody TypeEntity type){
		typeService.save(type);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("passjavaquestion:type:update")
    public R update(@RequestBody TypeEntity type){
		typeService.updateById(type);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("passjavaquestion:type:delete")
    public R delete(@RequestBody Long[] ids){
		typeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
