package org.haiyang.orderdemo.listener;

import org.haiyang.orderdemo.handler.OrderProcessingChain;
import org.haiyang.orderdemo.handler.impl.*;
import org.haiyang.orderdemo.po.OrderCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class OrderEventListener {
    @EventListener
    public void handleOrderCreatedEvent(OrderCreatedEvent event) {
        System.out.println("责任链模式*********************");
        OrderProcessingChain chain = new OrderProcessingChain();
        chain.addHandler(new GenerateOrderIdHandler());
        chain.addHandler(new RedisHandler());
        chain.addHandler(new NotifyServiceHandler());
        chain.addHandler(new StockServiceHandler());
        chain.addHandler(new LogServiceHandler());

        chain.process(event);
    }
}
