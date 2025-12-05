package com.cnkart.item.service;


import com.cnkart.item.dto.ItemRequest;
import com.cnkart.item.dto.ItemResponse;
import com.cnkart.item.model.Item;
import com.cnkart.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ItemService {

    private final ItemRepository itemRepository;

    public void createItem(ItemRequest productRequest) {
        Item product = Item.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        itemRepository.save(product);
        log.info("Item {} is saved", product.getId());
    }

    public List<ItemResponse> getAllItems() {
        List<Item> products = itemRepository.findAll();

        return products.stream().map(this::mapToItemResponse).collect(Collectors.toList());
    }

    private ItemResponse mapToItemResponse(Item product) {
        return ItemResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
