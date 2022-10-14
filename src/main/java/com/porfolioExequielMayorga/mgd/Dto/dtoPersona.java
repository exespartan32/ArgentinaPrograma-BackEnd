/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolioExequielMayorga.mgd.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author exema
 */
public class dtoPersona {

    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;

    private String img;
    
    // constructor
    public dtoPersona() {
    }

    public dtoPersona(String nombre, String apellido, String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
    }
    
    // Getters & Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
