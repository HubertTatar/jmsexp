package com.hutatar.jmsexp.domain;

public enum OrderStatus {

    CREATED("CREATED"),
    PENDING("PENDING"),
    CONFIRMED("CONFIRMED"),
    FAILED("FAILED");

    private String status;

    private OrderStatus(final String status){
        this.status = status;
    }

    public String getStatus(){
        return this.status;
    }

    @Override
    public String toString(){
        return this.status;
    }


    public String getName(){
        return this.name();
    }
}
