package com.miguel.engeneering.frozzenlist.services;

import com.miguel.engeneering.frozzenlist.models.Product;
import com.miguel.engeneering.frozzenlist.models.ProductType;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface ProductService {

    Product saveProduct(Product product);
    Map<Long,Product> saveProducts(Map<Long,Product>products);
    Product findProductById(Long id);
    Map<Long,Product> findProductsById(List<Long> ids);

    List<Product>findProductsByProductType(Map<Long,Product>products,ProductType type);
    Map<Long,Product> findProductsByFreezable(Map<Long,Product>products);
    Map<Long,Product> findProductsByExpiryDate(Map<Long,Product>products,LocalDate dateOfExpiry);

    boolean deleteById(Long id);
    void deleteAll(List<Long>ids);

    List<Product> sortProductByName(Map<Long,Product>products);
    List<Product> sortProductByQuantity(Map<Long,Product>products);
    List<Product> sortProductByDateOfBought(Map<Long,Product>products);
}
