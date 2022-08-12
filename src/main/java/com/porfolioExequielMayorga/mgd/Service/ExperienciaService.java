/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolioExequielMayorga.mgd.Service;

import com.porfolioExequielMayorga.mgd.Entity.Experiencia;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.porfolioExequielMayorga.mgd.Repository.ExperienciaRepository;

/**
 *
 * @author usuario
 */
@Service
@Transactional
public class ExperienciaService {

    @Autowired
    ExperienciaRepository rExperiencia;

    // busca y devuelbe todas las experiencias que hay
    public List<Experiencia> list() {
        return rExperiencia.findAll();
    }

    // busca y devuelbe una experiencia por id
    public Optional<Experiencia> getOne(int id) {
        return rExperiencia.findById(id);
    }

    // busca y devuelbe una experiencia por nombre
    public Optional<Experiencia> getByNombreE(String nombreE) {
        return rExperiencia.findByNombreE(nombreE);
    }

    // guarda una experiencia
    public void save(Experiencia expe) {
        rExperiencia.save(expe);
    }

    // borra una experiencia
    public void delete(int id) {
        rExperiencia.deleteById(id);
    }

    // compuebua si ya existe experiencia por id
    public boolean existsById(int id) {
        return rExperiencia.existsById(id);
    }

    // compuebua si ya existe experiencia por nombre
    public boolean existsByNombreE(String nombreE) {
        return rExperiencia.existsByNombreE(nombreE);
    }
}
