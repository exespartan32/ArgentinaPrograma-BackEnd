package com.porfolioExequielMayorga.mgd.Controller;

import com.porfolioExequielMayorga.mgd.Entity.Banner;
import com.porfolioExequielMayorga.mgd.Security.Controller.Mensaje;
import com.porfolioExequielMayorga.mgd.Service.BannerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.porfolioExequielMayorga.mgd.Dto.dtoBanner;

import java.util.List;

@RestController
@RequestMapping("/banner")
@CrossOrigin(origins = "https://front-end-argentina-programa.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class BannerController {
    @Autowired
    BannerService bannerService;

    @GetMapping("/list")
    public ResponseEntity<List<Banner>> list(){
        List<Banner> list = bannerService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Banner> getById(@PathVariable("id") Long id) {
        if (!bannerService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        Banner banner = bannerService.getOne(id).get();
        return new ResponseEntity(banner, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (!bannerService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        bannerService.delete(id);
        return new ResponseEntity(new Mensaje("Banner eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoBanner dtobanner, Banner banner){
        if (StringUtils.isBlank(dtobanner.getImagenBanner())){
            return new ResponseEntity(new Mensaje("la url de la imagen es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        banner = new Banner(
                dtobanner.getImagenBanner()
        );
        bannerService.save(banner);
        return new ResponseEntity(new Mensaje("Banner agregado correctamente"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody dtoBanner dtobanner){
        if (!bannerService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if (StringUtils.isBlank(dtobanner.getImagenBanner())){
            return new ResponseEntity(new Mensaje("la url de la imagen es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        Banner banner = bannerService.getOne(id).get();
        banner.setImagenBanner(dtobanner.getImagenBanner());

        bannerService.save(banner);
        return new ResponseEntity(new Mensaje("Banner Actualizado"), HttpStatus.OK);
    }

    @GetMapping("/traer")
    public Banner findPersona() {
        return bannerService.findBanner((long) 1);
    }

}
