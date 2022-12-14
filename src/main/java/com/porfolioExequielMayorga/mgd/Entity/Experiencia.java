/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolioExequielMayorga.mgd.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author usuario
 */
@Entity
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud especificada")
    private String nombreExperiencia;
    
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud especificada")
    private String descripcionExperiencia;
    
    private String imagenExperiencia;

    //Constructores
    public Experiencia() {
    }

    public Experiencia(String nombreExperiencia, String descripcionExperiencia, String imagenExperiencia) {
        this.nombreExperiencia = nombreExperiencia;
        this.descripcionExperiencia = descripcionExperiencia;
        this.imagenExperiencia = imagenExperiencia;
    }

    //Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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