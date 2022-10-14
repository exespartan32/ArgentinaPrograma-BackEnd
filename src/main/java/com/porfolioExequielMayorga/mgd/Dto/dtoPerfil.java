package com.porfolioExequielMayorga.mgd.Dto;

import javax.validation.constraints.NotBlank;

public class dtoPerfil {
    @NotBlank
    private Long id;

    @NotBlank
    private String profesion;

    @NotBlank
    private String acercaDe;

    // constructor

    public dtoPerfil() {
    }

    public dtoPerfil(String profesion, String acercaDe) {
        this.profesion = profesion;
        this.acercaDe = acercaDe;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getAcercaDe() {
        return acercaDe;
    }

    public void setAcercaDe(String acercaDe) {
        this.acercaDe = acercaDe;
    }
}
