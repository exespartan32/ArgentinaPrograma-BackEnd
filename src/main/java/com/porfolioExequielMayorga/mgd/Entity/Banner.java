package com.porfolioExequielMayorga.mgd.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imagenBanner;

    // constructor
    public Banner() {
    }

    public Banner(String imagenBanner) {
        this.imagenBanner = imagenBanner;
    }
    // Setters & Getters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagenBanner() {
        return imagenBanner;
    }

    public void setImagenBanner(String imagenBanner) {
        this.imagenBanner = imagenBanner;
    }
}
