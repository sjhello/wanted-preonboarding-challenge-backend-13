package com.wanted.preonboarding.cafe.controller;

import com.wanted.preonboarding.cafe.dto.MenuDto;
import com.wanted.preonboarding.cafe.dto.OrderDto;
import com.wanted.preonboarding.cafe.dto.OrderResultDto;
import com.wanted.preonboarding.cafe.service.CafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/cafe")
@RequiredArgsConstructor
public class CafeController {
    private final CafeService cafeService;

    @GetMapping("hello")
    public String welcomeMessage() {
        return "Welcome to The Wanted coding cafe!!";
    }

    @GetMapping("order")
    public String orderFromMenu() {
        HashMap<String, Integer> menu = new HashMap<String, Integer>();
        menu.put("AMERICANO", 3);
        menu.put("MILK", 3);
        menu.put("LATTE", 3);
        return cafeService.orderFrom(menu);
    }

    @PostMapping("order-test")
    public OrderResultDto orderFromMenuTest(@RequestBody List<MenuDto> menuDtos) {
        List<OrderDto> orderDtos = menuDtos.stream()
                .map(menuDto ->
                        OrderDto.builder()
                                .name(menuDto.getName())
                                .quantity(menuDto.getQuantity())
                                .price(100L)        // Service로 분리 도메인 단에서 price값 알 수 있게 수정
                                .build())
                .toList();

//        return cafeService.orderFromTest(orderDtos);
        return new OrderResultDto(orderDtos, 0L);
    }
}
