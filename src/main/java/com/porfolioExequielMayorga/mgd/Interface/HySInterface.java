package com.porfolioExequielMayorga.mgd.Interface;

import com.porfolioExequielMayorga.mgd.Entity.HyS;

import java.util.List;
import java.util.Optional;

public interface HySInterface {
    // lista todas las hys que hay
    public List<HyS> list();
    // busca y devuelbe una hys por id
    public Optional<HyS> getOne(int id);
    // busca y devuelbe una hys por nombre
    public Optional<HyS> getByNombre(String nombre);
    // guarda una hys
    public void save(HyS skill);
    // borra una experiencia
    public void delete(int id);
    // comprueba si ya existe hys por id
    public boolean existsById(int id);
    // comprueba si ya existe hys por nombre
    public boolean existsByNombre(String nombre);
}
