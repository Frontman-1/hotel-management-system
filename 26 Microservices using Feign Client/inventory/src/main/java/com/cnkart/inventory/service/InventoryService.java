package com.cnkart.inventory.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cnkart.inventory.model.Inventory;
import com.cnkart.inventory.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public boolean isInStock(Long skuCode, Integer qty) {
        log.info("Checking Inventory");
        Optional<Inventory> inventoryOptional = inventoryRepository.findBySkuCode(String.valueOf(skuCode));
        
        if (inventoryOptional.isEmpty()) {
            log.warn("SKU code {} not found in inventory", skuCode);
            return false;
        }
        
        Inventory inventory = inventoryOptional.get();
        return inventory.getQuantity() >= qty;
    }
}
