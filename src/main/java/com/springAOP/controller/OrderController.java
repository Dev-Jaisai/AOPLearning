package com.springAOP.controller;

import com.springAOP.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/order")
    public ResponseEntity<String> orderProcess() {
        String message = orderService.processOrder("Iphone Is ordering");
        return ResponseEntity.ok(message);
    }

}
