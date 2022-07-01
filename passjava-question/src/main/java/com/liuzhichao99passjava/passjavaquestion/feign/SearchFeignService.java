package com.liuzhichao99passjava.passjavaquestion.feign;

import com.liuzhichao99.common.to.es.QuestionEsModel;
import com.liuzhichao99.common.utils.R;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Mapper
@FeignClient("passjava-search")
public interface SearchFeignService {
    @PostMapping("search/question/save")
    R saveQuestion(@RequestBody QuestionEsModel questionEsModel);
}
