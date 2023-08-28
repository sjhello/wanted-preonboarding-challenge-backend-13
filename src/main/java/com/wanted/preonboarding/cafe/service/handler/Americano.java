package com.wanted.preonboarding.cafe.service.handler;

public class Americano extends Beverage {

    protected Americano(String name, Long price) {
        super(name, price);
    }

    @Override
    protected String getName() {
        return "AMERICANO";
    }

    @Override
    protected Long getPrice() {
        return 100L;
    }
}
