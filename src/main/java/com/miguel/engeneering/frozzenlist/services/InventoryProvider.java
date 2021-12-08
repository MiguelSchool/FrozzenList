package com.miguel.engeneering.frozzenlist.services;

import com.miguel.engeneering.frozzenlist.models.Inventory;

public interface InventoryProvider {
    Inventory getInventory(String name);
    Inventory getInventory(String name, String inventoryName);

}
