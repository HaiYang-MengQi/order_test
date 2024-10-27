package org.haiyang.orderdemo.handler.impl;

import org.haiyang.orderdemo.handler.OrderHandler;
import org.haiyang.orderdemo.po.OrderCreatedEvent;
import org.springframework.stereotype.Component;

@Component
public class StockServiceHandler implements OrderHandler {
    @Override
    public void handle(OrderCreatedEvent event) {
        System.out.println("功能2: 调用库存服务-扣减库存(可以异步,微服务可以rabbitmq)");
    }
}
