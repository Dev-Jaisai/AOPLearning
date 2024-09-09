package com.springAOP.service;

import org.springframework.stereotype.Service;

@Service
public class OrderService {
    public String processOrder(String orderName) {
        System.out.println("Processing order: " + orderName);
        return "Order " + orderName + " processed";
    }
}
