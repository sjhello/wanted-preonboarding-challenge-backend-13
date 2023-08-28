package com.wanted.preonboarding.cafe.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderDto {

    private String name;
    private Long quantity;
    private Long price;

    @Builder
    public OrderDto(String name, Long quantity, Long price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}
