package com.catalog.apimodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO implements Serializable {
    private Integer id;
    private String studentName;
    private String studentClass;
    private Integer year;
}
