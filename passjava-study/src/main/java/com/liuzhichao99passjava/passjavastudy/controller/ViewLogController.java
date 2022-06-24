package com.liuzhichao99passjava.passjavastudy.controller;

import com.liuzhichao99.common.utils.PageUtils;
import com.liuzhichao99.common.utils.R;
import com.liuzhichao99passjava.passjavastudy.entity.ViewLogEntity;
import com.liuzhichao99passjava.passjavastudy.service.ViewLogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 学习-用户学习浏览记录表
 *
 * @author liuzhichao99
 * @email 7823628@qq.com
 * @date 2022-06-23 03:51:13
 */
@RestController
@RequestMapping("passjavastudy/viewlog")
public class ViewLogController {
    @Autowired
    private ViewLogService viewLogService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("passjavastudy:viewlog:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = viewLogService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("passjavastudy:viewlog:info")
    public R info(@PathVariable("id") Long id){
		ViewLogEntity viewLog = viewLogService.getById(id);

        return R.ok().put("viewLog", viewLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("passjavastudy:viewlog:save")
    public R save(@RequestBody ViewLogEntity viewLog){
		viewLogService.save(viewLog);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("passjavastudy:viewlog:update")
    public R update(@RequestBody ViewLogEntity viewLog){
		viewLogService.updateById(viewLog);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("passjavastudy:viewlog:delete")
    public R delete(@RequestBody Long[] ids){
		viewLogService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
