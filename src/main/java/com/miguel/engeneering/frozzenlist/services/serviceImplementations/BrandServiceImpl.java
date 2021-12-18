package com.miguel.engeneering.frozzenlist.services.serviceImplementations;


import com.miguel.engeneering.frozzenlist.models.Brand;
import com.miguel.engeneering.frozzenlist.repositories.BrandRepository;
import com.miguel.engeneering.frozzenlist.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandRepository brandRepository;

    @Override
    public Brand saveBrand(Brand brand) {
        return this.brandRepository.save(brand);
    }

    @Override
    public List<Brand> saveBrands(List<Brand> brandList) {
        List<Brand>brandsTemp= new ArrayList<>();
        brandList.forEach(brand -> brandsTemp.add(this.brandRepository.save(brand)));
        return brandsTemp;
    }

    @Override
    public Brand findBrandById(Long id) {
        return this.brandRepository.findById(id).orElse(null);
    }

    @Override
    public List<Brand> findBrandsByIds(List<Long> ids) {
        List<Brand>brandList = new ArrayList<>();
        ids.forEach(id-> brandList.add(this.findBrandById(id)));
        return brandList;
    }

    @Override
    public boolean deleteBrandById(Long id) {
        if(this.brandRepository.existsById(id)){
            this.brandRepository.findById(id);
            return true;
        }
        return false;
    }

    @Override
    public void deleteAllById(List<Long> ids) {
        ids.forEach(this::findBrandById);
    }
}
