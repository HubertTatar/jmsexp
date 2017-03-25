package com.hutatar.jmsexp.dto;

import com.hutatar.jmsexp.domain.OrderStatus;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
public class OrderDto {
    //fields from abstract
    private BigInteger id;
    private LocalDateTime createdDate;
    private LocalDateTime modificationDate;
    //fields from order
    @NotNull
    private String productName;
    private int quantity;
    private OrderStatus status;
}
