/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolioExequielMayorga.mgd.Service;

import com.porfolioExequielMayorga.mgd.Entity.Persona;
import com.porfolioExequielMayorga.mgd.Interface.IPersonaService;
import com.porfolioExequielMayorga.mgd.Repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author usuario
 */
@Service
public class ImpPersonaService implements IPersonaService{
    @Autowired IPersonaRepository ipersonaRepository;
    
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
}
