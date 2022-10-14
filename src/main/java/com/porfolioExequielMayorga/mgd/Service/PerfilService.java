package com.porfolioExequielMayorga.mgd.Service;

import com.porfolioExequielMayorga.mgd.Entity.Educacion;
import com.porfolioExequielMayorga.mgd.Entity.Perfil;
import com.porfolioExequielMayorga.mgd.Interface.PerfilInterface;
import com.porfolioExequielMayorga.mgd.Repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilService implements PerfilInterface {
    @Autowired
    PerfilRepository perfilRepository;

    @Override
    // busca y devuelbe todas los perfiles que hay
    public List<Perfil> list() {
        return perfilRepository.findAll();
    }

    @Override
    // busca y devuelbe un perfil por id
    public Optional<Perfil> getOne(Long id) {
        return perfilRepository.findById(id);
    }

    @Override
    // guarda un perfil
    public void save(Perfil perfil) {
        perfilRepository.save(perfil);
    }

    @Override
    // borra un perfil
    public void delete(Long id) {
        perfilRepository.deleteById(id);
    }

    @Override
    // compruebua si ya existe un perfil por id
    public boolean existsById(Long id) {
        return perfilRepository.existsById(id);
    }

    @Override
    // compueba si ya existe experiencia por profesion
    public boolean existsByProfesion(String profesion) {
        return perfilRepository.existsByProfesion(profesion);
    }
}
