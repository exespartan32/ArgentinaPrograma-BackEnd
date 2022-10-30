package com.porfolioExequielMayorga.mgd.Repository;

import com.porfolioExequielMayorga.mgd.Entity.HyS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface HySRepository extends JpaRepository<HyS, Integer> {
    Optional<HyS> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
