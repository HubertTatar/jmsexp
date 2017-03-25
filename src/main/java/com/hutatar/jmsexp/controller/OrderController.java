package com.hutatar.jmsexp.controller;

import com.hutatar.jmsexp.dto.OrderDto;
import com.hutatar.jmsexp.domain.Order;
import com.hutatar.jmsexp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public void createOrder(OrderDto orderDto) {
        orderService.sendOrder(orderDto);
    }

    @GetMapping("/list")
    public List<Order> listOrders() {
        return orderService.getAllOrders();
    }
}
