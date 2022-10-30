/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolioExequielMayorga.mgd.Service;

import com.porfolioExequielMayorga.mgd.Entity.Persona;
import com.porfolioExequielMayorga.mgd.Interface.IPersonaService;
import com.porfolioExequielMayorga.mgd.Repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 *
 * @author usuario
 */
@Service
@Transactional
public class ImpPersonaService implements IPersonaService {

    @Autowired
    IPersonaRepository ipersonaRepository;

    // trater una lista de personas
    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = ipersonaRepository.findAll();
        return persona;
    }

    // guardar/crear una persona
    @Override
    public void savePersona(Persona persona) {
        ipersonaRepository.save(persona);
    }

    // eliminar una persona
    @Override
    public void deletePersona(Long id) {
        ipersonaRepository.deleteById(id);
    }

    // buscar una persona por ID
    @Override
    public Persona findPersona(Long id) {
        Persona persona = ipersonaRepository.findById(id).orElse(null);
        return persona;
    }

    // busca si existe esa persona por id
    @Override
    public boolean existsById(Long id) {
        return ipersonaRepository.existsById(id);
    }

    // busca si existe esa persona por el nombre
    @Override
    public boolean existsByNombreP(String nombre) {
        return ipersonaRepository.existsByNombre(nombre);
    }

    //busca una persona por ids
    @Override
    public Optional<Persona> getOne(Long id) {
        return ipersonaRepository.findById(id);
    }

    // busca persona por nombre
    @Override
    public Optional<Persona> getByNombreP(String nombre) {
        return ipersonaRepository.findByNombre(nombre);
    }
    
    
}
