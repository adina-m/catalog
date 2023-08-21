package com.catalog.models;

import java.util.List;

public class Student {

    private Integer student_id;
    private String nume;
    private String grupa;
    private Integer an_studii;

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getGrupa() {
        return grupa;
    }

    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }

    public Integer getAn_studii() {
        return an_studii;
    }

    public void setAn_studii(Integer an_studii) {
        this.an_studii = an_studii;
    }
}
