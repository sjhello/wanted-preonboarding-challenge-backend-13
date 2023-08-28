package com.wanted.preonboarding.cafe.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MenuDto {

    private String name;
    private Long quantity;

    public MenuDto(String name, Long quantity) {
        this.name = name;
        this.quantity = quantity;
    }
}
