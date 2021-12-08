package com.miguel.engeneering.frozzenlist.models.factorys;

import com.miguel.engeneering.frozzenlist.models.Inventory;
import com.miguel.engeneering.frozzenlist.services.InventoryProvider;

public class InventoryRefrigerator implements InventoryProvider {

    @Override
    public Inventory getInventory(String name) {
        return new Inventory(name);
    }

    @Override
    public Inventory getInventory(String name, String inventoryName) {
        return new Inventory(name,inventoryName);
    }
}
