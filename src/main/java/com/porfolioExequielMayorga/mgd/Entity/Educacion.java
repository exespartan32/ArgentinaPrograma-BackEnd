/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolioExequielMayorga.mgd.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author usuario
 */
@Entity
public class Educacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombreEducacion;
	private String descripcionEducacion;
	private String imagenEducacion;

	// constructor
	public Educacion() {
	}

	public Educacion(String nombreEducacion, String descripcionEducacion, String imagenEducacion) {
		super();
		this.nombreEducacion = nombreEducacion;
		this.descripcionEducacion = descripcionEducacion;
		this.imagenEducacion = imagenEducacion;
	}

	// Setters & Getters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
