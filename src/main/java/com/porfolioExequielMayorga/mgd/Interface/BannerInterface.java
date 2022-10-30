package com.porfolioExequielMayorga.mgd.Interface;


import com.porfolioExequielMayorga.mgd.Entity.Banner;

import java.util.List;
import java.util.Optional;

public interface BannerInterface {
    public List<Banner> list();
    public Optional<Banner> getOne(Long id);
    public void save(Banner banner);
    public void delete(Long id);
    public boolean existsById(Long id);

    public Banner findBanner(Long id);
}
