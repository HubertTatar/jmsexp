package com.hutatar.jmsexp.service;

import com.hutatar.jmsexp.dto.OrderDto;
import com.hutatar.jmsexp.messaging.InventoryResponse;
import com.hutatar.jmsexp.messaging.MessageSender;
import com.hutatar.jmsexp.domain.Order;
import com.hutatar.jmsexp.domain.OrderStatus;
import com.hutatar.jmsexp.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger LOG = LoggerFactory.getLogger(OrderServiceImpl.class);

    private MessageSender messageSender;
    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(MessageSender messageSender, OrderRepository orderRepository) {
        this.messageSender = messageSender;
        this.orderRepository = orderRepository;
    }

    @Override
    public void sendOrder(OrderDto orderDto) {
        Order order = dtoToDomain(orderDto);
        LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        order.setStatus(OrderStatus.PENDING);
        orderRepository.save(order);
        LOG.info("Application : sending order request {}", order);
        messageSender.sendMessage(order);
        LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    @Override
    public void updateOrder(InventoryResponse response) {

        Order order = orderRepository.getOne(response.getOrderId());
        if(response.getReturnCode()==200){
            order.setStatus(OrderStatus.CONFIRMED);
        }else if(response.getReturnCode()==300){
            order.setStatus(OrderStatus.FAILED);
        }else{
            order.setStatus(OrderStatus.PENDING);
        }
        orderRepository.save(order);
    }

    @Override
    public OrderDto findOrder(BigInteger id) {
        return domainToDto(orderRepository.getOne(id));
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return dtoFromList(orderRepository.findAll());
    }

    private List<OrderDto> dtoFromList(List<Order> orders) {
        return orders.stream().map(o -> {
            return domainToDto(o);
        }).collect(Collectors.toList());
    }

    private OrderDto domainToDto(Order o) {
        return OrderDto.builder()
                .id(o.getId())
                .createdDate(o.getCreatedDate())
                .modificationDate(o.getModificationDate())
                .productName(o.getProductName())
                .quantity(o.getQuantity())
                .status(o.getStatus())
                .build();
    }

    private Order dtoToDomain(OrderDto orderDto, Order order) {
        return Order.builder()
                .id(order.getId())
                .version(order.getVersion())
                .createdDate(order.getCreatedDate())
                .modificationDate(order.getModificationDate())
                .productName(orderDto.getProductName())
                .quantity(orderDto.getQuantity())
                .status(orderDto.getStatus())
                .build();
    }

    private Order dtoToDomain(OrderDto orderDto) {
        return Order.builder()
                .id(orderDto.getId())
                .createdDate(orderDto.getCreatedDate())
                .modificationDate(orderDto.getModificationDate())
                .productName(orderDto.getProductName())
                .quantity(orderDto.getQuantity())
                .status(orderDto.getStatus())
                .build();
    }

}
