package com.miguel.engeneering.frozzenlist.services;

import com.miguel.engeneering.frozzenlist.models.ProductType;

public class ProductTypeFactory {

    public static ProductType getProductType(String name) {
        return new ProductType(name);
    }

    public static ProductType getProductType(String name, double minStockValue) {
        return new ProductType(name, minStockValue);
    }

    public static ProductType getProductType(String name, double minStockValue, double maxStockValue) {
        return new ProductType(name, minStockValue, maxStockValue);
    }
}
