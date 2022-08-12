/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.porfolioExequielMayorga.mgd.Repository;

import com.porfolioExequielMayorga.mgd.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author usuario
 */
public interface IPersonaRepository extends JpaRepository<Persona,Long>{
    
}
