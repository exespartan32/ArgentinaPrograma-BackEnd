package com.porfolioExequielMayorga.mgd.Interface;


import com.porfolioExequielMayorga.mgd.Entity.Proyecto;

import java.util.List;
import java.util.Optional;

public interface ProyectoInterface {
    public List<Proyecto> list();

    public Optional<Proyecto> getOne(Long id);

    public void save(Proyecto proyecto);

    public void delete(Long id);

    public boolean existById(Long id);

    public boolean existByNombreProyecto(String nombreProyecto);

    public Proyecto findProyect(Long id);

    public Optional<Proyecto> getByNombreProyecto(String nombreProyecto);
}
