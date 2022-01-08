package com.miguel.engeneering.frozzenlist.controllers;

import com.miguel.engeneering.frozzenlist.models.Inventory;
import com.miguel.engeneering.frozzenlist.models.User;
import com.miguel.engeneering.frozzenlist.models.factories.InventoryServiceFactory;
import com.miguel.engeneering.frozzenlist.models.factories.strategies.FreezerProvider;
import com.miguel.engeneering.frozzenlist.models.factories.strategies.FridgeProvider;
import com.miguel.engeneering.frozzenlist.models.factories.strategies.InventoryProvider;
import com.miguel.engeneering.frozzenlist.models.factories.strategies.StorageRoomProvider;
import com.miguel.engeneering.frozzenlist.services.serviceImplementations.InventoryServiceImpl;
import com.miguel.engeneering.frozzenlist.services.serviceImplementations.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/inventories")
@AllArgsConstructor
public class InventoryController {

    private final UserServiceImpl userService;
    private final InventoryServiceImpl inventoryService;

    @PostMapping
    public ResponseEntity<Inventory>createInventory(@RequestBody User user, @RequestBody Inventory inventory) {
        if( inventory.getType().getName().equals("freezer")) {
            userService.addInventory(user,new FreezerProvider(),inventory.getName());
        }
        else if(inventory.getType().getName().equals("fridge")) {
            userService.addInventory(user,new FridgeProvider(),inventory.getName());
        }
        else if(inventory.getType().getName().equals("StorageRoom")) {
            userService.addInventory(user,new StorageRoomProvider(),inventory.getName());
        }
        userService.saveUser(user);
        return Optional.of(inventoryService.saveInventory(inventory))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
