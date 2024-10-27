package org.haiyang.orderdemo.handler.impl;

import org.haiyang.orderdemo.handler.OrderHandler;
import org.haiyang.orderdemo.po.OrderCreatedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class GenerateOrderIdHandler implements OrderHandler {
    @Override
    public void handle(OrderCreatedEvent event) {
        String orderId = "order:" + event.getUserId();
        event.setOrderId(orderId);
        event.setCreateTime(LocalDateTime.now());
        System.out.println("订单创建功能(生成订单号返回): " + orderId);
    }
}
