package com.miguel.engeneering.frozzenlist.services;

import com.miguel.engeneering.frozzenlist.models.Inventory;

public class InventoryServiceFactory {

    public static Inventory getInventory(InventoryProvider provider, String name) {
        return provider.getInventory(name);
    }
    public static Inventory getInventory(InventoryProvider provider, String name, String inventoryName) {
        return provider.getInventory(name,inventoryName);
    }
}
