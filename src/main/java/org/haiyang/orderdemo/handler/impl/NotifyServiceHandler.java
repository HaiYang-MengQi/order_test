package org.haiyang.orderdemo.handler.impl;

import org.haiyang.orderdemo.handler.OrderHandler;
import org.haiyang.orderdemo.po.OrderCreatedEvent;
import org.springframework.stereotype.Component;

@Component
public class NotifyServiceHandler implements OrderHandler {
    @Override
    public void handle(OrderCreatedEvent event) {
        System.out.println("功能1: 调用通知服务-微信通知/短信通知");
    }
}
