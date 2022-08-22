/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolioExequielMayorga.mgd.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author usuario
 */
public class dtoExperiencia {

    @NotBlank
    private String nombreExperiencia;
    @NotBlank
    private String descripcionExperiencia;
    
    private String imagenExperiencia;

    // constructor
    public dtoExperiencia() {
    }
    
    public dtoExperiencia(String nombreExperiencia, String descripcionExperiencia, String imagenExperiencia) {
        this.nombreExperiencia = nombreExperiencia;
        this.descripcionExperiencia = descripcionExperiencia;
        this.imagenExperiencia = imagenExperiencia;
    }

    // Getters & Setters
    public String getNombreExperiencia() {
        return nombreExperiencia;
    }

    public void setNombreExperiencia(String nombreExperiencia) {
        this.nombreExperiencia = nombreExperiencia;
    }

    public String getDescripcionExperiencia() {
        return descripcionExperiencia;
    }

    public void setDescripcionExperiencia(String descripcionExperiencia) {
        this.descripcionExperiencia = descripcionExperiencia;
    }

    public String getImagenExperiencia() {
        return imagenExperiencia;
    }

    public void setImagenExperiencia(String imagenExperiencia) {
        this.imagenExperiencia = imagenExperiencia;
    }
}
