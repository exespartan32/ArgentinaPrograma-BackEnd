/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.porfolioExequielMayorga.mgd.Interface;

import com.porfolioExequielMayorga.mgd.Entity.Persona;

import java.util.List;
import java.util.Optional;

/**
 * @author usuario
 */
public interface IPersonaService {

    // trater una lista de personas
    public List<Persona> getPersona();

    // guardar un objeto de tipo persona
    public void savePersona(Persona persona);

    // Eliminar un objeto persona buscando por ID
    public void deletePersona(Long id);

    // buscar persona por ID
    public Persona findPersona(Long id);

    // comnpueba si existe persona por ID
    public boolean existsById(Long id);

    // comprueba si existe persona por nombre
    public boolean existsByNombreP(String nombre);

    // busca y devuelbe una experiencia por nombre
    public Optional<Persona> getByNombreP(String nombre);

    // busca y devuelbe una experiencia por id
    public Optional<Persona> getOne(Long id);
}
