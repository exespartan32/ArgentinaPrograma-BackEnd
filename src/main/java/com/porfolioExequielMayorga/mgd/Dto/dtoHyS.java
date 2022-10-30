package com.porfolioExequielMayorga.mgd.Dto;

import javax.validation.constraints.NotBlank;

public class dtoHyS {
    @NotBlank
    private int id;
    @NotBlank
    private String nombre;
    @NotBlank
    private int porcentaje;

    private String imagenHyS;

    public dtoHyS() {
    }

    public dtoHyS(String nombre, int porcentaje, String imagenHyS) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.imagenHyS = imagenHyS;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getImagenHyS() {
        return imagenHyS;
    }

    public void setImagenHyS(String imagenHyS) {
        this.imagenHyS = imagenHyS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
