package com.cnkart.order.service;


import java.util.UUID;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cnkart.order.dto.OrderRequest;
import com.cnkart.order.model.Order;
import com.cnkart.order.repository.OrderRepository;


@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;

    public OrderService(OrderRepository orderRepository, RestTemplate restTemplate) {
        this.orderRepository = orderRepository;
        this.restTemplate = restTemplate;
    }

    public String placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setPrice(orderRequest.getPrice());
        order.setQuantity(orderRequest.getQuantity());
        order.setSkuCode(orderRequest.getSkuCode());

        // Call Inventory Service, and place order if product is in stock
        
        String resourceUrl = "http://inventory-service/api/inventory?skuCode={skuCode}&qty={qty}";
        boolean isInStock
                = Boolean.TRUE.equals(restTemplate.getForEntity(resourceUrl, Boolean.class,orderRequest.getSkuCode(),orderRequest.getQuantity()).getBody());

        if(isInStock) {
            orderRepository.save(order);
            return "Order Placed";
        }
        else {
            return "Item is not in stock, please try again later";
            }


    }
}
