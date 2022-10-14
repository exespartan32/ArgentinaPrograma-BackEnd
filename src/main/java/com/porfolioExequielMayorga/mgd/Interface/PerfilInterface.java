package com.porfolioExequielMayorga.mgd.Interface;

import com.porfolioExequielMayorga.mgd.Entity.Perfil;

import java.util.List;
import java.util.Optional;

public interface PerfilInterface {
    // busca y devuelbe todas los perfiles que hay
    public List<Perfil> list();

    // busca y devuelbe un perfil por id
    public Optional<Perfil> getOne(Long id);

    // guarda un perfil
    public void save(Perfil perfil);

    // borra un perfil
    public void delete(Long id);

    // compueba si ya existe un perfil por id
    public boolean existsById(Long id);

    // compueba si ya existe experiencia por profesion
    public boolean existsByProfesion(String profesion);
}
