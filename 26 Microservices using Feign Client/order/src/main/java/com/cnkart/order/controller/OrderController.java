package com.cnkart.order.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cnkart.order.dto.OrderRequest;
import com.cnkart.order.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @HystrixCommand(fallbackMethod = "fallbackPlaceOrder")
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        log.info("Placing Order");
        return orderService.placeOrder(orderRequest);
    }
    
    public String fallbackPlaceOrder(@RequestBody OrderRequest orderRequest) {
    	return "Service is Not available";
    }
}
