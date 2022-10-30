/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolioExequielMayorga.mgd.Controller;

import com.porfolioExequielMayorga.mgd.Dto.dtoPersona;
import com.porfolioExequielMayorga.mgd.Entity.Persona;
import com.porfolioExequielMayorga.mgd.Security.Controller.Mensaje;
import com.porfolioExequielMayorga.mgd.Service.ImpPersonaService;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author usuario
 */
@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "https://front-end-argentina-programa.web.app")
//@CrossOrigin(origins = "http://localhost:4200/")
public class PersonaController {

    @Autowired
    ImpPersonaService ipersonaService;

    // traer una lista de personas 
    @GetMapping("/traer")
    public List<Persona> getPersona() {
        return ipersonaService.getPersona();
    }

    // crear una persona
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public String createPersona(@RequestBody Persona persona) {
        ipersonaService.savePersona(persona);

        return "La Persona fue creada Correctamente";
    }

    // borra una persona por id
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public String deletePersona(@PathVariable Long id) {
        ipersonaService.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }

    // busca los detalles de la persona por id
    // busca persona 
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") Long id) {
        if (!ipersonaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        Persona persona = ipersonaService.findPersona((long) 1);
        return new ResponseEntity(persona, HttpStatus.OK);
    }

    // actualiza persona
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody dtoPersona dtoPer) {
        // Validamos si existe el ID
        if (!ipersonaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        // Compara nombre de personas
        if (ipersonaService.existsByNombreP(dtoPer.getNombre())
                && ipersonaService.getByNombreP(dtoPer.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa persona ya existe"), HttpStatus.BAD_REQUEST);
        }
        // No puede estar vacio
        if (StringUtils.isBlank(dtoPer.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Persona persona = ipersonaService.getOne(id).get();
        persona.setNombre(dtoPer.getNombre());
        persona.setApellido(dtoPer.getApellido());
        persona.setImg(dtoPer.getImg());

        ipersonaService.savePersona(persona);
        return new ResponseEntity(new Mensaje("Persona actualizada correctamente"), HttpStatus.OK);
    }

    @GetMapping("/traer/perfil")
    public Persona findPersona() {
        return ipersonaService.findPersona((long) 1);
    }
}
