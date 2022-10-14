package com.porfolioExequielMayorga.mgd.Controller;

import com.porfolioExequielMayorga.mgd.Dto.dtoExperiencia;
import com.porfolioExequielMayorga.mgd.Dto.dtoPerfil;
import com.porfolioExequielMayorga.mgd.Entity.Perfil;
import com.porfolioExequielMayorga.mgd.Security.Controller.Mensaje;
import com.porfolioExequielMayorga.mgd.Service.PerfilService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfil")
//@CrossOrigin(origins = "https://front-end-argentina-programa.web.app")
@CrossOrigin(origins = "http://localhost:4200")
public class PerfilController {
    @Autowired
    PerfilService perfilService;

    // busca y devuelbe todas los perfiles que hay
    @GetMapping("/lista")
    public ResponseEntity<List<Perfil>> list() {
        List<Perfil> list = perfilService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }


    // busca y devuelbe un perfil por id
    @GetMapping("/detail/{id}")
    public ResponseEntity<List<Perfil>> getById(@PathVariable("id") Long id) {
        if (!perfilService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Perfil perfil = perfilService.getOne(id).get();
        return new ResponseEntity(perfil, HttpStatus.OK);
    }

    // guarda un perfil
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoPerfil dtoPer, Perfil perfil) {
        if (StringUtils.isBlank(dtoPer.getProfesion())) {
            return new ResponseEntity(new Mensaje("La profecion es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if (perfilService.existsByProfesion(dtoPer.getProfesion())) {
            return new ResponseEntity(new Mensaje("Este Perfil ya existe"), HttpStatus.BAD_REQUEST);
        }
        perfil = new Perfil(dtoPer.getProfesion(), dtoPer.getAcercaDe());
        perfilService.save(perfil);
        return new ResponseEntity(new Mensaje("Perfil agregado correctamente"), HttpStatus.OK);
    }

    // borra un perfil
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (!perfilService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        perfilService.delete(id);
        return new ResponseEntity(new Mensaje("perfil eliminado correctamente"), HttpStatus.OK);
    }

    // actualizar perfil
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody dtoPerfil dtoPer) {
        // Validamos si existe el ID
        if (!perfilService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        // No puede estar vacio
        if (StringUtils.isBlank(dtoPer.getProfesion())) {
            return new ResponseEntity(new Mensaje("La profesion es obligatoria"), HttpStatus.BAD_REQUEST);
        }

        Perfil perfil = perfilService.getOne(id).get();
        perfil.setProfesion(dtoPer.getProfesion());
        perfil.setAcercaDe(dtoPer.getAcercaDe());

        perfilService.save(perfil);
        return new ResponseEntity(new Mensaje("Perfil actualizado correctamente"), HttpStatus.OK);
    }
}
