/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.porfolioExequielMayorga.mgd.Repository;

import com.porfolioExequielMayorga.mgd.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author usuario
 */
public interface EducacionRepository extends JpaRepository<Educacion, Integer>{
    public Optional<Educacion> findByNombreE(String nombreE);
    public boolean existsByNombreE(String nombreE);
}
