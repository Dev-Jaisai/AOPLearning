package com.springAOP.service;

import org.springframework.stereotype.Service;

/**
 * OrderService handles the business logic for processing, updating, and canceling orders.
 *
 * Author: Jaisai Sarkate
 * Time: September 9, 2024
 * Objective: To define and implement the core business methods for handling order-related operations.
 */
@Service
public class OrderService {

    /**
     * Processes an order.
     *
     * Objective: To simulate processing of an order by printing a message and returning a confirmation.
     *
     * @param orderName The name of the order being processed.
     * @return A confirmation message indicating that the order has been processed.
     */
    public String processOrder(String orderName) {
        System.out.println("Processing order: " + orderName);
        return "Order " + orderName + " processed";
    }

    /**
     * Cancels an order.
     *
     * Objective: To simulate the cancellation of an order by printing a message and returning a confirmation.
     *
     * @param orderName The name of the order being canceled.
     * @return A confirmation message indicating that the order has been cancelled.
     */
    public String cancelOrder(String orderName) {
        System.out.println("Cancelling order: " + orderName);
        return "Order " + orderName + " cancelled";
    }

    /**
     * Updates an order.
     *
     * Objective: To simulate updating an existing order by printing a message and returning a confirmation.
     *
     * @param orderName The name of the order being updated.
     * @return A confirmation message indicating that the order has been updated.
     */
    public String updateOrder(String orderName) {
        System.out.println("Updating order: " + orderName);
        return "Order " + orderName + " updated";
    }
}
