package com.miguel.engeneering.frozzenlist.models.factories;

import com.miguel.engeneering.frozzenlist.models.Inventory;
import com.miguel.engeneering.frozzenlist.models.factories.strategies.InventoryProvider;

public class InventoryServiceFactory {

    public static Inventory getInventory(InventoryProvider provider, String name) {
        return provider.getInventory(name);
    }

    public static Inventory getInventory(InventoryProvider provider, String name, String inventoryName) {
        return provider.getInventory(name,inventoryName);
    }
}
