package com.hutatar.jmsexp.dto;

import com.hutatar.jmsexp.domain.OrderStatus;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
public class OrderDto extends AbstractDto {
    @NotNull
    private String productName;
    private int quantity;
    private OrderStatus status;

    @Builder
    public OrderDto(BigInteger id, Integer version, LocalDateTime createdDate, LocalDateTime modificationDate, String productName, int quantity, OrderStatus status) {
        super(id, version, createdDate, modificationDate);
        this.productName = productName;
        this.quantity = quantity;
        this.status = status;
    }
}
