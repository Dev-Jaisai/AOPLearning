package com.springAOP.controller;

import com.springAOP.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    // Endpoint to process an order
    @GetMapping("/order")
    public ResponseEntity<String> orderProcess() {
        String message = orderService.processOrder("Iphone Is ordering");
        return ResponseEntity.ok(message);
    }

    // New endpoint to cancel an order
    @GetMapping("/order/cancel/{orderName}")
    public ResponseEntity<String> cancelOrder(@PathVariable String orderName) {
        String message = orderService.cancelOrder(orderName);
        return ResponseEntity.ok(message);
    }

    // New endpoint to update an order
    @GetMapping("/order/update/{orderName}")
    public ResponseEntity<String> updateOrder(@PathVariable String orderName) {
        String message = orderService.updateOrder(orderName);
        return ResponseEntity.ok(message);
    }
}
