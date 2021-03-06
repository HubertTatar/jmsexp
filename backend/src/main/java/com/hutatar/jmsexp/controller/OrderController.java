package com.hutatar.jmsexp.controller;

import com.hutatar.jmsexp.dto.OrderDto;
import com.hutatar.jmsexp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public void post(@RequestBody OrderDto orderDto) {
        orderService.sendOrder(orderDto);
    }

    @GetMapping("/{id}")
    public OrderDto get(@PathVariable BigInteger id) {
        return orderService.findOrder(id);
    }

    @GetMapping("/list")
    public List<OrderDto> getAll() {
        return orderService.getAllOrders();
    }

    @PutMapping("/{id}")
    public void put(@RequestBody OrderDto orderDto) {
    }
}
