package com.catalog.apimodel;

import lombok.Data;

import java.util.Date;

@Data
public class ExamDTO {
    private Integer examId;
    private String group;
    private String course;
    private String name;
    private Date date;
    private String classroom;
}
