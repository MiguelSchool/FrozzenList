package com.miguel.engeneering.frozzenlist.services.serviceImplementations;

import com.miguel.engeneering.frozzenlist.models.InventoryType;
import com.miguel.engeneering.frozzenlist.repositories.InventoryTypeRepository;
import com.miguel.engeneering.frozzenlist.services.InventoryTypeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class InventoryTypeServiceImpl implements InventoryTypeService {

    InventoryTypeRepository inventoryTypeRepository;

    @Override
    public InventoryType saveInventoryType(InventoryType inventoryType) {
        return this.inventoryTypeRepository.save(inventoryType);
    }

    @Override
    public List<InventoryType> saveInventoryTypes(List<InventoryType> inventoryTypes) {
        inventoryTypes.forEach(this::saveInventoryType);
        return inventoryTypes;
    }

    @Override
    public InventoryType findInventoryByID(Long id) {
        return this.inventoryTypeRepository.findById(id).orElse(null);
    }

    @Override
    public List<InventoryType> findAllByID(List<Long> ids) {
        List<InventoryType> inventoryTypes= new ArrayList<>();
        ids.forEach(id -> inventoryTypes.add(this.findInventoryByID(id)));
        return inventoryTypes;
    }

    @Override
    public boolean deleteById(Long id) {
        if(this.inventoryTypeRepository.existsById(id)){
            this.inventoryTypeRepository.findById(id);
            return true;
        }
        return false;
    }

    @Override
    public void deleteAll(List<Long> ids) {
        ids.forEach(this::deleteById);
    }
}
