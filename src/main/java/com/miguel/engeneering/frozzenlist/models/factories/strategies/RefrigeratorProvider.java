package com.miguel.engeneering.frozzenlist.models.factories.strategies;

import com.miguel.engeneering.frozzenlist.models.Inventory;
import com.miguel.engeneering.frozzenlist.models.InventoryType;


public class RefrigeratorProvider implements InventoryProvider {

    @Override
    public Inventory getInventory(String name) {
        InventoryType inventoryType = new InventoryType();
        inventoryType.setName("Refrigerator");
        return new Inventory(name, inventoryType);
    }

    @Override
    public Inventory getInventory(String name, String inventoryPlace) {
        InventoryType inventoryType = new InventoryType();
        inventoryType.setName("Refrigerator");
        return new Inventory(name, inventoryPlace, inventoryType);
    }
}

