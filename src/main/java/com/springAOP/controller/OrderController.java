package com.springAOP.controller;

import com.springAOP.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * OrderController handles HTTP requests for managing orders.
 * It exposes endpoints for processing, updating, and canceling orders.
 *
 * Author: Jaisai Sarkate
 * Time: September 9, 2024
 * Objective: To provide an interface for interacting with OrderService methods via REST API.
 */
@RestController
@RequiredArgsConstructor
public class OrderController {

    // Injecting OrderService to handle the business logic for orders.
    private final OrderService orderService;

    /**
     * Endpoint to process an order.
     *
     * Objective: To trigger the process of ordering a product.
     * Example: GET /order
     *
     * @return ResponseEntity containing the result of the order process.
     */
    @GetMapping("/order")
    public ResponseEntity<String> orderProcess() {
        String message = orderService.processOrder("Iphone Is ordering");
        return ResponseEntity.ok(message);
    }

    /**
     * Endpoint to cancel an order.
     *
     * Objective: To trigger the cancellation of an order.
     * Example: GET /order/cancel/{orderName}
     *
     * @param orderName The name of the order to cancel.
     * @return ResponseEntity containing the result of the cancellation process.
     */
    @GetMapping("/order/cancel/{orderName}")
    public ResponseEntity<String> cancelOrder(@PathVariable String orderName) {
        String message = orderService.cancelOrder(orderName);
        return ResponseEntity.ok(message);
    }

    /**
     * Endpoint to update an order.
     *
     * Objective: To trigger the update of an existing order.
     * Example: GET /order/update/{orderName}
     *
     * @param orderName The name of the order to update.
     * @return ResponseEntity containing the result of the update process.
     */
    @GetMapping("/order/update/{orderName}")
    public ResponseEntity<String> updateOrder(@PathVariable String orderName) {
        String message = orderService.updateOrder(orderName);
        return ResponseEntity.ok(message);
    }
}
