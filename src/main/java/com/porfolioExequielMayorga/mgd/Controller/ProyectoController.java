package com.porfolioExequielMayorga.mgd.Controller;

import com.porfolioExequielMayorga.mgd.Entity.Proyecto;
import com.porfolioExequielMayorga.mgd.Dto.dtoProyecto;
import com.porfolioExequielMayorga.mgd.Security.Controller.Mensaje;
import com.porfolioExequielMayorga.mgd.Service.ProyectoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyecto")
@CrossOrigin(origins = "https://front-end-argentina-programa.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class ProyectoController {
    @Autowired
    ProyectoService proyectoService;

    @GetMapping("/list")
    public ResponseEntity<List<Proyecto>>list() {
        List<Proyecto> list = proyectoService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") Long id) {
        if(!proyectoService.existById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        Proyecto proyecto = proyectoService.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if(!proyectoService.existById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        proyectoService.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyecto dtoproyecto, Proyecto proyecto){
        if (StringUtils.isBlank(dtoproyecto.getNombreProyecto())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(proyectoService.existByNombreProyecto(dtoproyecto.getNombreProyecto())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        proyecto = new Proyecto(
                dtoproyecto.getNombreProyecto(),
                dtoproyecto.getDescripcionProyecto(),
                dtoproyecto.getImagenProyecto(),
                dtoproyecto.getLinkProyecto()
        );
        proyectoService.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto agregado correctamente"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody dtoProyecto dtoproyecto){
        if(!proyectoService.existById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        if(proyectoService.existByNombreProyecto(dtoproyecto.getNombreProyecto())
        && proyectoService.getByNombreProyecto(dtoproyecto.getNombreProyecto()).get().getId()!= id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoproyecto.getNombreProyecto())){
            return new ResponseEntity(new Mensaje("El campo nombre no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        Proyecto proyecto = proyectoService.getOne(id).get();
        proyecto.setNombreProyecto(dtoproyecto.getNombreProyecto());
        proyecto.setDescripcionProyecto(dtoproyecto.getDescripcionProyecto());
        proyecto.setImagenProyecto(dtoproyecto.getImagenProyecto());
        proyecto.setLinkProyecto(dtoproyecto.getLinkProyecto());

        proyectoService.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto actualizado actualizada"), HttpStatus.OK);
    }

}
