package com.porfolioExequielMayorga.mgd.Dto;

import javax.validation.constraints.NotBlank;

public class dtoBanner {
    @NotBlank
    private String imagenBanner;

    public dtoBanner() {
    }

    public dtoBanner(String imagenBanner) {
        this.imagenBanner = imagenBanner;
    }

    public String getImagenBanner() {
        return imagenBanner;
    }

    public void setImagenBanner(String imagenBanner) {
        this.imagenBanner = imagenBanner;
    }
}
