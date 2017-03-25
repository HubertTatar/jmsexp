package com.hutatar.jmsexp.service;

import com.hutatar.jmsexp.dto.OrderDto;
import com.hutatar.jmsexp.domain.Order;
import com.hutatar.jmsexp.messaging.InventoryResponse;

import java.util.List;

public interface OrderService {
    void sendOrder(OrderDto orderDto);

    void updateOrder(InventoryResponse inventoryResponse);

    List<Order> getAllOrders();
}