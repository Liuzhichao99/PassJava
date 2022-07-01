package com.liuzhichao99passjava.passjavachannel.controller;

import com.liuzhichao99.common.utils.*;


import com.liuzhichao99passjava.passjavachannel.entity.AccessTokenEntity;
import com.liuzhichao99passjava.passjavachannel.service.AccessTokenService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 渠道-认证表
 *
 * @author liuzhichao99
 * @email 7823628@qq.com
 * @date 2022-06-23 02:24:49
 */
@RestController
@RequestMapping("channel/accesstoken")
public class AccessTokenController {
    @Autowired
    private AccessTokenService accessTokenService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("passjavachannel:accesstoken:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = accessTokenService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("passjavachannel:accesstoken:info")
    public R info(@PathVariable("id") Long id){
		AccessTokenEntity accessToken = accessTokenService.getById(id);

        return R.ok().put("accessToken", accessToken);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("passjavachannel:accesstoken:save")
    public R save(@RequestBody AccessTokenEntity accessToken){
		accessTokenService.save(accessToken);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("passjavachannel:accesstoken:update")
    public R update(@RequestBody AccessTokenEntity accessToken){
		accessTokenService.updateById(accessToken);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("passjavachannel:accesstoken:delete")
    public R delete(@RequestBody Long[] ids){
		accessTokenService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
