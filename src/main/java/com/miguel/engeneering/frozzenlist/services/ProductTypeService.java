package com.miguel.engeneering.frozzenlist.services;

import com.miguel.engeneering.frozzenlist.models.ProductType;

import java.util.List;

public interface ProductTypeService {

    ProductType saveProductType(ProductType productType);
    List<ProductType> saveProductTypes(List<ProductType>productTypes);

    boolean deleteById(Long id);
    void deleteByIds(List<Long> ids);

    List<ProductType> findProductTypesByName(List<ProductType>productTypes, String name);

    List<ProductType>sortProductTypeListByType(List<ProductType>productTypes);

}
