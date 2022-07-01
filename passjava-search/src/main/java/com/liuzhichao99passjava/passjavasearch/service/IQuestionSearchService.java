package com.liuzhichao99passjava.passjavasearch.service;

import com.liuzhichao99passjava.passjavasearch.vo.SearchParam;
import com.liuzhichao99passjava.passjavasearch.vo.SearchQuestionResponse;

public interface IQuestionSearchService {
    SearchQuestionResponse search(SearchParam param);
}
