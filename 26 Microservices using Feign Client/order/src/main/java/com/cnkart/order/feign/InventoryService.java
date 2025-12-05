package com.cnkart.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "INVENTORY-SERVICE")
public interface InventoryService {
	@GetMapping("/api/inventory?skuCode={skuCode}&qty={qty}")
    public boolean isInStock(@RequestParam Long skuCode,@RequestParam Integer qty);
}
