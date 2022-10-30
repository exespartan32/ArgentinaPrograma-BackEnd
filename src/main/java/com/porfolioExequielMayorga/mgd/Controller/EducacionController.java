/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolioExequielMayorga.mgd.Controller;

import com.porfolioExequielMayorga.mgd.Dto.dtoEducacion;
import com.porfolioExequielMayorga.mgd.Entity.Educacion;
import com.porfolioExequielMayorga.mgd.Security.Controller.Mensaje;
import com.porfolioExequielMayorga.mgd.Service.EducacionService;
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
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author usuario
 */
@RestController
@RequestMapping("/educacion")
@CrossOrigin(origins = "https://front-end-argentina-programa.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class EducacionController {

	@Autowired
	EducacionService educacionService;

	// trae todas las educaciones
	@GetMapping("/list")
	public ResponseEntity<List<Educacion>> list() {
		List<Educacion> list = educacionService.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}

	// busca educacion por id
	@GetMapping("/detail/{id}")
	public ResponseEntity<Educacion> getById(@PathVariable("id") int id) {
		if (!educacionService.existsById(id)) {
			return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
		}
		Educacion educacion = educacionService.getOne(id).get();
		return new ResponseEntity(educacion, HttpStatus.OK);
	}

	// borra educacion por id
	//@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		if (!educacionService.existsById(id)) {
			return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
		}
		educacionService.delete(id);
		return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
	}

	// crea nueva educacion
	//@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody dtoEducacion dtoeducacion, Educacion educacion) {
		if (StringUtils.isBlank(dtoeducacion.getNombreEducacion())) {
			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		}
		if (educacionService.existsByNombreE(dtoeducacion.getNombreEducacion())) {
			return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
		}
		educacion = new Educacion(
				dtoeducacion.getNombreEducacion(), 
				dtoeducacion.getDescripcionEducacion(),
				dtoeducacion.getImagenEducacion()
				);
//		System.out.println("datos recibidos de font end");
//		System.out.println(educacion);
        educacionService.save(educacion);
		return new ResponseEntity(new Mensaje("Educacion agregada correctamente"), HttpStatus.OK);
	}

	// actualiza educacion
	//@PreAuthorize("hasRole('ADMIN')")
		@PutMapping("/update/{id}")
		public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoeducacion) {
		if (!educacionService.existsById(id)) {
			return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
		}
		if (educacionService.existsByNombreE(dtoeducacion.getNombreEducacion())
				&& educacionService.getByNombreE(dtoeducacion.getNombreEducacion()).get().getId() != id) {
			return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
		}
		if (StringUtils.isBlank(dtoeducacion.getNombreEducacion())) {
			return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
		}

		Educacion educacion = educacionService.getOne(id).get();

		educacion.setNombreEducacion(dtoeducacion.getNombreEducacion());
		educacion.setDescripcionEducacion(dtoeducacion.getDescripcionEducacion());
		educacion.setImagenEducacion(dtoeducacion.getImagenEducacion());

		educacionService.save(educacion);
		return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
	}
}
