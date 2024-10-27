package org.haiyang.orderdemo.handler;

import org.haiyang.orderdemo.handler.OrderHandler;
import org.haiyang.orderdemo.po.OrderCreatedEvent;

import java.util.ArrayList;
import java.util.List;


public class OrderProcessingChain {
    private final List<OrderHandler> handlers = new ArrayList<>();

    public void addHandler(OrderHandler handler) {
        handlers.add(handler);
    }

    public void process(OrderCreatedEvent event) {
        for (OrderHandler handler : handlers) {
            handler.handle(event);
        }
    }
}
