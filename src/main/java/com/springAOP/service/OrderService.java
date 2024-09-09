package com.springAOP.service;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

    // Existing method
    public String processOrder(String orderName) {
        System.out.println("Processing order: " + orderName);
        return "Order " + orderName + " processed";
    }

    // New method 1: Cancel an order
    public String cancelOrder(String orderName) {
        System.out.println("Cancelling order: " + orderName);
        return "Order " + orderName + " cancelled";
    }

    // New method 2: Update an order
    public String updateOrder(String orderName) {
        System.out.println("Updating order: " + orderName);
        return "Order " + orderName + " updated";
    }
}
