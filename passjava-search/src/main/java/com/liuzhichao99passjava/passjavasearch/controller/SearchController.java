package com.liuzhichao99passjava.passjavasearch.controller;

import com.liuzhichao99passjava.passjavasearch.service.IQuestionSearchService;
import com.liuzhichao99passjava.passjavasearch.vo.SearchParam;
import com.liuzhichao99passjava.passjavasearch.vo.SearchQuestionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/search")
@RestController
public class SearchController {

    @Autowired
    IQuestionSearchService questionSearchService;

    @PostMapping("/question/list")
    public SearchQuestionResponse list(SearchParam param) {

        return questionSearchService.search(param);

    }
}
