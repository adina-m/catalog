package com.catalog.models;

import java.util.Date;
import java.util.List;

public class Examen {

    private Integer examen_id;
    private String grupa;
    private String materie;
    private String nume_profesor;
    private Date data_examen;
    private String sala;

    public Integer getExamen_id() {
        return examen_id;
    }

    public void setExamen_id(Integer examen_id) {
        this.examen_id = examen_id;
    }

    public String getGrupa() {
        return grupa;
    }

    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }

    public String getMaterie() {
        return materie;
    }

    public void setMaterie(String materie) {
        this.materie = materie;
    }

    public String getNume_profesor() {
        return nume_profesor;
    }

    public void setNume_profesor(String nume_profesor) {
        this.nume_profesor = nume_profesor;
    }

    public Date getData_examen() {
        return data_examen;
    }

    public void setData_examen(Date data_examen) {
        this.data_examen = data_examen;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }
}
