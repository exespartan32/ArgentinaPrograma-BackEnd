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
public class dtoEducacion {

	@NotBlank
	private String nombreEducacion;
	@NotBlank
	private String descripcionEducacion;

	private String imagenEducacion;

	// constructor
	public dtoEducacion() {
	}

	public dtoEducacion(String nombreEducacion, String descripcionEducacion, String imagenEducacion) {
		this.nombreEducacion = nombreEducacion;
		this.descripcionEducacion = descripcionEducacion;
		this.imagenEducacion = imagenEducacion;
	}

	// Getters & Setters
	public String getNombreEducacion() {
		return nombreEducacion;
	}

	public void setNombreEducacion(String nombreEducacion) {
		this.nombreEducacion = nombreEducacion;
	}

	public String getDescripcionEducacion() {
		return descripcionEducacion;
	}

	public void setDescripcionEducacion(String descripcionEducacion) {
		this.descripcionEducacion = descripcionEducacion;
	}

	public String getImagenEducacion() {
		return imagenEducacion;
	}

	public void setImagenEducacion(String imagenEducacion) {
		this.imagenEducacion = imagenEducacion;
	}
}
