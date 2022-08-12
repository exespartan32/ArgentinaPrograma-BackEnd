/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.porfolioExequielMayorga.mgd.Security.Repository;

import com.porfolioExequielMayorga.mgd.Security.Entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author usuario
 */
@Repository
public interface iUsuarioRepository extends JpaRepository<Usuario, Integer>{
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    
    // ¿exiete el nombre de usuario?
    boolean existsByNombreUsuario(String nombreUsuario);
    // ¿exiete el email?
    boolean existsByEmail(String email);
}
