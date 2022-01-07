package com.miguel.engeneering.frozzenlist.services.serviceImplementations;

import com.miguel.engeneering.frozzenlist.models.ProductType;
import com.miguel.engeneering.frozzenlist.repositories.ProductTypeRepository;
import com.miguel.engeneering.frozzenlist.services.ProductTypeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;


@Service
@AllArgsConstructor
public class ProductTypeServiceImpl implements ProductTypeService {

    ProductTypeRepository productTypeRepository;

    @Override
    public ProductType saveProductType(ProductType productType) {
        return this.productTypeRepository.save(productType);
    }

    @Override
    public List<ProductType> saveProductTypes(List<ProductType> productTypes) {
        List<ProductType>types = new ArrayList<>();
        Iterator<ProductType>productTypeIterator = productTypes.iterator();
        while(productTypeIterator.hasNext()){
            types.add(this.saveProductType(productTypeIterator.next()));
        }
        return types;
    }

    @Override
    public boolean deleteById(Long id) {
        if(this.productTypeRepository.existsById(id)){
            this.productTypeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        ids.forEach(this::deleteById);
    }

    @Override
    public List<ProductType> findProductTypesByName(List<ProductType> productTypes, String name) {
        return productTypes.stream()
                           .filter(productType -> productType.getType().equals(name))
                           .toList();
    }

    @Override
    public List<ProductType> sortProductTypeListByType(List<ProductType> productTypes) {
        return productTypes.stream()
                           .sorted(Comparator.comparing(ProductType::getType))
                           .toList();
    }
}
