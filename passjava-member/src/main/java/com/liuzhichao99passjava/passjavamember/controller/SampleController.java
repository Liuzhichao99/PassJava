package com.liuzhichao99passjava.passjavamember.controller;

import com.liuzhichao99.common.utils.R;
import com.liuzhichao99passjava.passjavamember.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("member/sample")
public class SampleController {
    @Autowired
    MemberService memberService;

    @Value("${member.nickname}")
    private  String nickname;

    @Value("${member.age}")
    private  Integer age;

    @RequestMapping("/test-local-config")
    public R testLocalConfig() {
        return R.ok().put("nickname", nickname).put("age", age);
    }
}
