package com.miguel.engeneering.frozzenlist.services.serviceImplementations;

import com.miguel.engeneering.frozzenlist.models.Product;
import com.miguel.engeneering.frozzenlist.models.ProductType;
import com.miguel.engeneering.frozzenlist.repositories.ProductRepository;
import com.miguel.engeneering.frozzenlist.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public Map<Long, Product> saveProducts(Map<Long, Product> products) {
        Map<Long,Product>productMap = new HashMap<>();
        products.forEach((Long id, Product product) -> {
            this.saveProduct(product);
            productMap.put(product.getId(),product);
        });
        return productMap;
    }

    @Override
    public Product findProductById(Long id) {
        return this.productRepository.findById(id).orElse(null);
    }

    @Override
    public Map<Long, Product> findProductsById(List<Long> ids) {
        Map<Long,Product>productMap = new HashMap<>();
        ids.forEach(id -> {
            Product product = this.findProductById(id);
            productMap.put(product.getId(),product);
        });
        return productMap;
    }

    @Override
    public List<Product> findProductsByProductType(Map<Long,Product>products,ProductType type) {
        return products.values().parallelStream()
                                .filter(product -> product.getProductType().equals(type))
                                .toList();
    }

    @Override
    public Map<Long, Product> findProductsByFreezable(Map<Long,Product>products) {
        return products.values().parallelStream()
                .filter(Product::isFreezable)
                .collect(Collectors.toMap(Product::getId, product -> product));
    }

    @Override
    public Map<Long, Product> findProductsByExpiryDate(Map<Long,Product>products,LocalDate dateOfExpiry) {
        return products.values().parallelStream()
                                .filter(product -> product.getGoodUntil().equals(dateOfExpiry))
                                .collect(Collectors.toMap(Product::getId,product -> product));

    }

    @Override
    public boolean deleteById(Long id) {
        if(this.productRepository.existsById(id)){
            this.productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public void deleteAll(List<Long> ids) {
        ids.forEach(this::deleteById);
    }

    @Override
    public List<Product> sortProductByName(Map<Long, Product> products) {
        return products.values().parallelStream()
                                .sorted(Comparator.comparing(Product::getName))
                                .toList();

    }

    @Override
    public List<Product>  sortProductByQuantity(Map<Long, Product> products) {
        return products.values().stream()
                                .sorted(Comparator.comparing(Product::getQuantity))
                                .toList();
    }

    @Override
    public List<Product>  sortProductByDateOfBought(Map<Long, Product> products) {
        return products.values().stream()
                                .sorted(Comparator.comparing(Product::getBoughtAt))
                                .toList();
    }
}
