package com.catalog.apimodel;

import lombok.Data;

@Data
public class StudentDTO {
    private Integer id;
    private String studentName;
    private String studentClass;
    private Integer year;
}
