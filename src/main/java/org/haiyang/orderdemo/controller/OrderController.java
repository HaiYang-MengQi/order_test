package org.haiyang.orderdemo.controller;

import org.haiyang.orderdemo.anno.Locked;
import org.haiyang.orderdemo.dto.OrderRequestDto;
import org.haiyang.orderdemo.dto.OrderResponseDto;
import org.haiyang.orderdemo.po.Order;
import org.haiyang.orderdemo.po.Results;
import org.haiyang.orderdemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("/create")
    @Locked
    public Results<OrderResponseDto> create(@RequestBody @Validated OrderRequestDto orderRequestDto) {
        int stock = orderService.checkStock(orderRequestDto.getProductId());
        System.out.println("查库存数量为：" + stock);
        if (stock > 0) {
            orderService.createOrderAndPublishEvent(orderRequestDto);
        } else {
            return Results.error(new OrderResponseDto());
        }
        return Results.ok(new OrderResponseDto());
    }

    @GetMapping("/get")
    public Results<OrderResponseDto> get(@RequestParam int orderId) {
        Set<String> keys =  redisTemplate.opsForHash().keys("order:"+orderId);
        if (keys == null || keys.isEmpty()) { // 检查空集合
            System.out.println("去查数据库");
            List<Order> list = orderService.getOrderById(orderId);
            return Results.ok(new OrderResponseDto());
        } else {
            System.out.println("去查redis");
        }

        return Results.ok(new OrderResponseDto());
    }
}
