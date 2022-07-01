package com.liuzhichao99passjava.passjavamember.controller;

import com.liuzhichao99.common.utils.PageUtils;
import com.liuzhichao99.common.utils.R;
import com.liuzhichao99passjava.passjavamember.entity.MemberEntity;
import com.liuzhichao99passjava.passjavamember.feign.StudyTimeFeignService;
import com.liuzhichao99passjava.passjavamember.service.MemberService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 会员-会员表
 *
 * @author liuzhichao99
 * @email 7823628@qq.com
 * @date 2022-06-23 03:48:31
 */
@RestController
@RequestMapping("member/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @Autowired
    private StudyTimeFeignService studyTimeFeignService;

    @RequestMapping("/studytime/list/test/{id}")
    public R getMemberStudyTimeListTest(@PathVariable("id") Long id) {
        //mock数据库查到的会员信息
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setId(id); // 学习时长：100分钟
        memberEntity.setNickname("悟空聊架构");
        System.out.println(memberEntity);

        //远程调用拿到该用户的学习时长（学习时长是mock数据）
        R memberStudyTimeList = studyTimeFeignService.getMemberStudyTimeListTest(id);
        System.out.println(memberStudyTimeList);
        return R.ok().put("member", memberEntity).put("studytime", memberStudyTimeList.get("studytime"));
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("passjavamember:member:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = memberService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("passjavamember:member:info")
    public R info(@PathVariable("id") Long id){
		MemberEntity member = memberService.getById(id);

        return R.ok().put("member", member);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("passjavamember:member:save")
    public R save(@RequestBody MemberEntity member){
		memberService.save(member);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("passjavamember:member:update")
    public R update(@RequestBody MemberEntity member){
		memberService.updateById(member);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("passjavamember:member:delete")
    public R delete(@RequestBody Long[] ids){
		memberService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
