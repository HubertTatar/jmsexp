package com.hutatar.jmsexp.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="orders", schema = "orders", indexes = { @Index(name="orders_idx_1", columnList = "productName" ) } )
@Getter
public class Order extends AbstractEntity {

    private String productName;
    private int quantity;
    private OrderStatus status;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "order"
    )
    Set<OrderComment> comments = new HashSet<>();

    public Order() {}

    @Builder
    private Order(BigInteger id, Integer version, LocalDateTime createdDate, LocalDateTime modificationDate, String productName, int quantity, OrderStatus status) {
        super(id, version, createdDate, modificationDate);
        this.productName = productName;
        this.quantity = quantity;
        this.status = status;
    }

    @Enumerated(EnumType.STRING)
    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void changeStatus(OrderStatus newStatus) {
        if (OrderStatus.CREATED.equals(newStatus)) {
            throw new IllegalArgumentException("Status cannot be set to CREATED");
        }
        this.status = newStatus;
    }

    public void updateQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be less then 0");
        }
        this.quantity = quantity;
    }

    public void addComment(OrderComment comment){
        comments.add(comment);
        comment.setOrder(this);
    }

    public void removeComment(OrderComment comment){
        comments.add(comment);
        comment.setOrder(null);
    }
}
