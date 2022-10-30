package com.porfolioExequielMayorga.mgd.Service;

import com.porfolioExequielMayorga.mgd.Entity.Proyecto;
import com.porfolioExequielMayorga.mgd.Interface.ProyectoInterface;
import com.porfolioExequielMayorga.mgd.Repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProyectoService implements ProyectoInterface {
    @Autowired
    ProyectoRepository proyectoRepository;

    @Override
    public List<Proyecto> list() {
        return proyectoRepository.findAll();
    }

    @Override
    public Optional<Proyecto> getOne(Long id) {
        return proyectoRepository.findById(id);
    }

    @Override
    public void save(Proyecto proyecto) {
        proyectoRepository.save(proyecto);
    }

    @Override
    public void delete(Long id) {
        proyectoRepository.deleteById(id);
    }

    @Override
    public boolean existById(Long id) {
        return proyectoRepository.existsById(id);
    }

    @Override
    public boolean existByNombreProyecto(String nombreProyecto) {
        return proyectoRepository.existsByNombreProyecto(nombreProyecto);
    }

    @Override
    public Proyecto findProyect(Long id) {
        Proyecto proyecto = proyectoRepository.findById(id).orElse(null);
        return proyecto;
    }

    @Override
    public Optional<Proyecto> getByNombreProyecto(String nombreProyecto) {
        return proyectoRepository.findByNombreProyecto(nombreProyecto);
    }


}
