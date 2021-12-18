package com.miguel.engeneering.frozzenlist.services;

import com.miguel.engeneering.frozzenlist.models.Brand;

import java.util.List;

public interface BrandService {

    Brand saveBrand(Brand brand);
    List<Brand> saveBrands(List<Brand>brandList);
    Brand findBrandById(Long id);
    List<Brand>findBrandsByIds(List<Long>ids);
    boolean deleteBrandById(Long id);
    void deleteAllById(List<Long>ids);
}
