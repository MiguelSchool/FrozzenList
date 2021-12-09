package com.miguel.engeneering.frozzenlist.models.factories.strategies;

import com.miguel.engeneering.frozzenlist.models.Inventory;
import com.miguel.engeneering.frozzenlist.models.InventoryType;

public interface InventoryProvider {
    Inventory getInventory(String name);
    Inventory getInventory(String name, String inventoryPlace);

}
