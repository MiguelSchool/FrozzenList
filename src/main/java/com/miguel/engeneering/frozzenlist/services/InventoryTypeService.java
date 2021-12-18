package com.miguel.engeneering.frozzenlist.services;

import com.miguel.engeneering.frozzenlist.models.InventoryType;

import java.util.List;

public interface InventoryTypeService {
    public InventoryType saveInventoryType(InventoryType type);
    public List<InventoryType> saveInventoryTypes(List<InventoryType>types);

    public InventoryType findInventoryByID(Long id);
    public List<InventoryType> findAllByID(List<Long>ids);
    public boolean deleteById(Long id);
    public void deleteAll(List<Long> ids);
}
