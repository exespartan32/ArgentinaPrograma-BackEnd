/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolioExequielMayorga.mgd.Service;

import com.porfolioExequielMayorga.mgd.Entity.Educacion;
import com.porfolioExequielMayorga.mgd.Repository.EducacionRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author usuario
 */
@Service
@Transactional
public class EducacionService {

    @Autowired
    EducacionRepository rEducacion;

    // busca y devuelbe todas los estudios que hay
    public List<Educacion> list() {
        return rEducacion.findAll();
    }

    // busca y devuelbe un estudio por id
    public Optional<Educacion> getOne(int id) {
        return rEducacion.findById(id);
    }

    // busca y devuelbe una educacion por nombre
    public Optional<Educacion> getByNombreE(String nombre_edu) {
        return rEducacion.findByNombreEducacion(nombre_edu);
    }

    // guarda una educacion
    public void save(Educacion educacion) {
        rEducacion.save(educacion);
    }

    // borra una educacion
    public void delete(int id) {
        rEducacion.deleteById(id);
    }

    // compuebua si ya existe educacion por id
    public boolean existsById(int id) {
        return rEducacion.existsById(id);
    }

    // compuebua si ya existe educacion por id
    public boolean existsByNombreE(String nombre_edu) {
        return rEducacion.existsByNombreEducacion(nombre_edu);
    }
}
