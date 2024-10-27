package org.haiyang.orderdemo.handler;

import org.haiyang.orderdemo.po.OrderCreatedEvent;

public interface OrderHandler {
    void handle(OrderCreatedEvent event);
}
