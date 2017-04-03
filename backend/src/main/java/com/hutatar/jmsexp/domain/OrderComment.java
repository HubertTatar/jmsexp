package com.hutatar.jmsexp.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "order_comments", schema = "orders")
public class OrderComment extends AbstractEntity {

    private String text;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "order_id", foreignKey = @ForeignKey(name="order_comments_fk1"))
    private Order order;

    public OrderComment(){}
    public OrderComment(String text){
        this.text = text;
    }

}
