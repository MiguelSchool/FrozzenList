package com.miguel.engeneering.frozzenlist.services.serviceImplementations;

import com.miguel.engeneering.frozzenlist.models.Inventory;
import com.miguel.engeneering.frozzenlist.models.InventoryType;
import com.miguel.engeneering.frozzenlist.repositories.InventoryRepository;
import com.miguel.engeneering.frozzenlist.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.stream.Collectors;

public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public Inventory saveInventory(Inventory inventory) {
        return this.inventoryRepository.save(inventory);
    }

    @Override
    public Set<Inventory> saveInventory(Set<Inventory> inventories) {
        inventories.forEach(this::saveInventory);
        return inventories;
    }

    @Override
    public Inventory findInventoryById(Long id) {
        return this.inventoryRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Inventory> findAllByID(List<Long> ids) {
        Set<Inventory>filteredInventories = new HashSet<>();
        ids.forEach(value -> filteredInventories.add(this.findInventoryById(value)));
        return filteredInventories;
    }

    @Override
    public Inventory findByName(String name) {
        Inventory inventoryTemp = null;
        Iterator<Inventory>inventoryIterator = this.inventoryRepository.findAll().iterator();
        while (inventoryIterator.hasNext()){
            if(inventoryIterator.next().getName().equals(name)){
                inventoryTemp = inventoryIterator.next();
            }
        }
        return inventoryTemp;
    }

    @Override
    public Inventory findBYInventoryPlace(String place) {
       Inventory temp = null;
       Iterator<Inventory>inventoryIterator = this.inventoryRepository.findAll().iterator();
       while (inventoryIterator.hasNext()){
           if(inventoryIterator.next().getInventoryPlace().equals(place)){
               temp = inventoryIterator.next();
           }
       }
       return temp;
    }

    @Override
    public Set<Inventory> sortByName(Set<Inventory> inventories) {
        return inventories.stream()
                          .sorted(Comparator.comparing(Inventory::getName))
                          .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    @Override
    public Set<Inventory> sortInventoryById(Set<Inventory> inventories) {
        return inventories.stream()
                          .sorted(Comparator.comparing(Inventory::getId))
                          .collect(Collectors.toCollection(TreeSet::new));
    }

    @Override
    public Set<Inventory> sortByInventoryType(Set<Inventory> inventories) {
        return inventories.stream()
                          .sorted(Comparator.comparing(t -> InventoryType.getName(t)))
                          .collect(Collectors.toCollection(TreeSet::new));

    }

    @Override
    public Set<Inventory> sortByNumberOfTrays(Set<Inventory> inventories) {
        return null;
    }
}
