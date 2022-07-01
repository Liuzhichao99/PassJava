package com.liuzhichao99passjava.passjavamember.feign;

import com.liuzhichao99.common.utils.R;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient("passjava-study")
public interface StudyTimeFeignService {

    //@RequestMapping("study/studytime/member/list/test")
    //public R getMemberStudyTimeListTest();

    @RequestMapping("study/studytime/member/list/test/{id}")
    public R getMemberStudyTimeListTest(@PathVariable("id") Long id);
}
