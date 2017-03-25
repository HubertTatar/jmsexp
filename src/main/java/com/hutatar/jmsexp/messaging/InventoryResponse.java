package com.hutatar.jmsexp.messaging;

import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

@Data
public class InventoryResponse implements Serializable {
    private BigInteger orderId;
    private int returnCode;
    private String comment;
}
