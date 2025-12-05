package com.cnkart.item.controller;

import com.cnkart.item.dto.ItemRequest;
import com.cnkart.item.dto.ItemResponse;
import com.cnkart.item.service.ItemService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createItem(@RequestBody ItemRequest productRequest) {
        itemService.createItem(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ItemResponse> getAllItems() {
        return itemService.getAllItems();
    }

}
