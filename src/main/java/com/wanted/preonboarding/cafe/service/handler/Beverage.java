package com.wanted.preonboarding.cafe.service.handler;

import lombok.Getter;

public abstract class Beverage {

    private String name;
    private Long price;

    protected Beverage(String name, Long price) {
        this.name = name;
        this.price = price;
    }

    protected abstract String getName();
    protected abstract Long getPrice();
}
