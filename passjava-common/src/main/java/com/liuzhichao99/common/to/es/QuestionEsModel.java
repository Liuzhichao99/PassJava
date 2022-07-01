package com.liuzhichao99.common.to.es;

import lombok.Data;

@Data
public class QuestionEsModel {
    private Long id;
    private String title;
    private String answer;
    private String typeName;
}
