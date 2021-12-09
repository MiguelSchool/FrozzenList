package com.miguel.engeneering.frozzenlist.models.factories;

import com.miguel.engeneering.frozzenlist.models.Brand;

public class BrandServiceFactory {
    public static Brand getBrand(String brand){
        return new Brand(brand);
    }
}
