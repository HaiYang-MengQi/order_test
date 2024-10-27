package org.haiyang.orderdemo.service.impl;

import org.haiyang.orderdemo.dao.OrderMapper;
import org.haiyang.orderdemo.dto.OrderRequestDto;
import org.haiyang.orderdemo.po.Order;
import org.haiyang.orderdemo.po.OrderCreatedEvent;
import org.haiyang.orderdemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Override
    public int checkStock(int productId) {
        return orderMapper.checkStock(productId);
    }

    private final ApplicationEventPublisher eventPublisher;

    public OrderServiceImpl(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }
    @Override
    public void createOrderAndPublishEvent(OrderRequestDto orderRequestDto) {
        OrderCreatedEvent event = new OrderCreatedEvent(null,orderRequestDto.getUserId(), orderRequestDto.getProductId(), orderRequestDto.getCount(),null);
        eventPublisher.publishEvent(event);
    }

    @Override
    public List<Order> getOrderById(int id) {
       return orderMapper.getOrderById(id);
    }


}
