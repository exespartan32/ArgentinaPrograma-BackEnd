package com.porfolioExequielMayorga.mgd.Service;

import com.porfolioExequielMayorga.mgd.Entity.HyS;
import com.porfolioExequielMayorga.mgd.Interface.HySInterface;
import com.porfolioExequielMayorga.mgd.Repository.HySRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class HySService implements HySInterface {
    @Autowired
    HySRepository hysRepository;

    // lista todas las hys que hay
    public List<HyS> list(){
        return hysRepository.findAll();
    }

    // busca y devuelbe una hys por id
    public Optional<HyS> getOne(int id){
        return hysRepository.findById(id);
    }

    // busca y devuelbe una hys por nombre
    public Optional<HyS> getByNombre(String nombre){
        return hysRepository.findByNombre(nombre);
    }

    // guarda una hys
    public void save(HyS skill){
        hysRepository.save(skill);
    }

    // borra una experiencia
    public void delete(int id){
        hysRepository.deleteById(id);
    }

    // comprueba si ya existe hys por id
    public boolean existsById(int id){
        return hysRepository.existsById(id);
    }

    // comprueba si ya existe hys por nombre
    public boolean existsByNombre(String nombre){
        return hysRepository.existsByNombre(nombre);
    }
}
