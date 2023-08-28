package com.wanted.preonboarding.cafe.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class OrderResultDto {

    private List<OrderDto> orderDtos;
    private Long totalPrice;

    public OrderResultDto(List<OrderDto> orderDtos, Long totalPrice) {
        this.orderDtos = orderDtos;
        this.totalPrice = totalPrice;
    }
}
