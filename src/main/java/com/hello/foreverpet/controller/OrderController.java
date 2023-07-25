package com.hello.foreverpet.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hello.foreverpet.domain.dto.request.OrderInfoRequest;
import com.hello.foreverpet.service.OrderService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<Long> createOrder(@RequestBody @Valid OrderInfoRequest orderInfoRequest) {
        Long orderNo = orderService.createOrder(orderInfoRequest);

        return ResponseEntity.ok(orderNo);
    }
    
}
