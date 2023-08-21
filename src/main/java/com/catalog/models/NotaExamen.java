package com.catalog.models;

public class NotaExamen {

    private Integer examen_id;
    private Integer student_id;
    private Integer nota;

    public Integer getExamen_id() {
        return examen_id;
    }

    public void setExamen_id(Integer examen_id) {
        this.examen_id = examen_id;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }
}
