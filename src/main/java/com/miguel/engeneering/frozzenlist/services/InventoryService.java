package com.miguel.engeneering.frozzenlist.services;

import com.miguel.engeneering.frozzenlist.models.Inventory;

import java.util.List;
import java.util.Set;

public interface InventoryService {

    public Inventory saveInventory(Inventory Inventory);
    public Set<Inventory> saveInventories(Set<Inventory> Inventory);

    public Inventory findInventoryById(Long id);
    public Set<Inventory> findAllByID(List<Long>ids);

    public boolean deleteById(Long id);
    public void deleteAll(List<Long> ids);

    public Inventory findByName(String name);
    public Inventory findBYInventoryPlace(String place);
    public Set<Inventory> sortByName(Set<Inventory>inventories);
    public Set<Inventory> sortInventoryById(Set<Inventory>inventories);
    public Set<Inventory>sortByInventoryTypeName(Set<Inventory>inventories);
    public Set<Inventory>sortByNumberOfTrays(Set<Inventory>inventories);
}
