package com.porfolioExequielMayorga.mgd.Controller;

import com.porfolioExequielMayorga.mgd.Entity.HyS;
import com.porfolioExequielMayorga.mgd.Dto.dtoHyS;
import com.porfolioExequielMayorga.mgd.Security.Controller.Mensaje;
import com.porfolioExequielMayorga.mgd.Service.HySService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/skill")
@CrossOrigin(origins = "https://front-end-argentina-programa.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class HySController {
    @Autowired
    HySService hysService;

    // lista todas las hys que hay
    @GetMapping("/list")
    public ResponseEntity<List<HyS>> list() {
        List<HyS> list = hysService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    // busca y devuelbe una hys por id
    @GetMapping("/detail/{id}")
    public ResponseEntity<HyS> getById(@PathVariable("id") int id) {
        if (!hysService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        HyS hys = hysService.getOne(id).get();
        return new ResponseEntity(hys, HttpStatus.OK);
    }

    // borra una hys por id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!hysService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        hysService.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminado"), HttpStatus.OK);
    }

    // guarda una hys
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHyS dtohys) {
        if (StringUtils.isBlank(dtohys.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (hysService.existsByNombre(dtohys.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }

        HyS hys = new HyS(
                dtohys.getNombre(),
                dtohys.getPorcentaje(),
                dtohys.getImagenHyS()
        );
        System.out.println("------------------------------------");
        System.out.println("------------------------------------");
        System.out.println("datos recibidos del FrontEnd");
        System.out.println(hys.getId());
        System.out.println(hys.getNombre());
        System.out.println(hys.getPorcentaje());
        System.out.println(hys.getImagenHyS());
        System.out.println("------------------------------------");
        System.out.println("------------------------------------");

        hysService.save(hys);
        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }

    // actualiza una hys
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHyS dtohys) {
        //Validamos si existe el ID
        if (!hysService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de skills
        if (hysService.existsByNombre(dtohys.getNombre()) && hysService.getByNombre(dtohys.getNombre()).get()
                .getId() != id) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtohys.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        HyS hys = hysService.getOne(id).get();
        hys.setNombre(dtohys.getNombre());
        hys.setPorcentaje(dtohys.getPorcentaje());
        hys.setImagenHyS((dtohys.getImagenHyS()));

        hysService.save(hys);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);
    }
}
