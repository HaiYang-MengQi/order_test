package org.haiyang.orderdemo.handler.impl;

import org.haiyang.orderdemo.handler.OrderHandler;
import org.haiyang.orderdemo.po.OrderCreatedEvent;
import org.springframework.stereotype.Component;

@Component
public class LogServiceHandler implements OrderHandler {
    @Override
    public void handle(OrderCreatedEvent event) {
        System.out.println("功能3: 调用日志服务-记录日志(可以异步,微服务可以rabbitmq)");
    }
}
