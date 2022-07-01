package com.liuzhichao99passjava.passjavachannel.controller;

import com.liuzhichao99.common.utils.PageUtils;
import com.liuzhichao99.common.utils.R;
import com.liuzhichao99passjava.passjavachannel.entity.ChannelEntity;
import com.liuzhichao99passjava.passjavachannel.service.ChannelService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 渠道-渠道表
 *
 * @author liuzhichao99
 * @email 7823628@qq.com
 * @date 2022-06-23 02:24:49
 */
@RestController
@RequestMapping("channel/channel")
public class ChannelController {
    @Autowired
    private ChannelService channelService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("passjavachannel:channel:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = channelService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("passjavachannel:channel:info")
    public R info(@PathVariable("id") Long id){
		ChannelEntity channel = channelService.getById(id);

        return R.ok().put("channel", channel);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("passjavachannel:channel:save")
    public R save(@RequestBody ChannelEntity channel){
		channelService.save(channel);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("passjavachannel:channel:update")
    public R update(@RequestBody ChannelEntity channel){
		channelService.updateById(channel);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("passjavachannel:channel:delete")
    public R delete(@RequestBody Long[] ids){
		channelService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
