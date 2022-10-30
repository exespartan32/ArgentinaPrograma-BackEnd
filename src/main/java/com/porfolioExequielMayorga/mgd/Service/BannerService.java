package com.porfolioExequielMayorga.mgd.Service;

import com.porfolioExequielMayorga.mgd.Entity.Banner;
import com.porfolioExequielMayorga.mgd.Interface.BannerInterface;
import com.porfolioExequielMayorga.mgd.Repository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class BannerService implements BannerInterface {

    @Autowired
    BannerRepository bannerRepository;


    @Override
    public List<Banner> list() {
        return bannerRepository.findAll();
    }

    @Override
    public Optional<Banner> getOne(Long id) {
        return bannerRepository.findById(id);
    }

    @Override
    public void save(Banner banner) {
        bannerRepository.save(banner);
    }

    @Override
    public void delete(Long id) {
        bannerRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return bannerRepository.existsById(id);
    }

    @Override
    public Banner findBanner(Long id) {
        Banner banner = bannerRepository.findById(id).orElse(null);
        return banner;
    }
}
