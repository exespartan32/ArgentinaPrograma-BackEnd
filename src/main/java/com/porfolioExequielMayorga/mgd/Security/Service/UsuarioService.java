/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolioExequielMayorga.mgd.Security.Service;

import com.porfolioExequielMayorga.mgd.Security.Entity.Usuario;
import com.porfolioExequielMayorga.mgd.Security.Repository.iUsuarioRepository;
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
public class UsuarioService {

    @Autowired
    iUsuarioRepository iusuarioRepository;

    // devuelbe nombre del usuario 
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario) {
        return iusuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    // compueba si existe nombre de usuario
    public boolean existsByNombreUsuario(String nombreUsuario) {
        return iusuarioRepository.existsByNombreUsuario(nombreUsuario);
    }

    // oompreba si existe email
    public boolean existsByEmail(String email) {
        return iusuarioRepository.existsByEmail(email);
    }

    // guarda los datos
    public void save(Usuario usuario) {
        iusuarioRepository.save(usuario);
    }
}
