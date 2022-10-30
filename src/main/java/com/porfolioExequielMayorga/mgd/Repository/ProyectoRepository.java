package com.porfolioExequielMayorga.mgd.Repository;

import com.porfolioExequielMayorga.mgd.Entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
    public Optional<Proyecto> findByNombreProyecto(String nombreProyecto);
    public boolean existsByNombreProyecto(String nombreProyecto);
}
