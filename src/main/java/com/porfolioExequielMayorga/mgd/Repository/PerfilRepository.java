package com.porfolioExequielMayorga.mgd.Repository;

import com.porfolioExequielMayorga.mgd.Entity.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {
public boolean existsByProfesion(String profesion);
}
