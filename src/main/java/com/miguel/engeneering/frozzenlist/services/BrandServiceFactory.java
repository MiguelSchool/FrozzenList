package com.miguel.engeneering.frozzenlist.services;

import com.miguel.engeneering.frozzenlist.models.Brand;

public class BrandServiceFactory {
    public static Brand getBrand(String brand){
        return new Brand(brand);
    }
}
