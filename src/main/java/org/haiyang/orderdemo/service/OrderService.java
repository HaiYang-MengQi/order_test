package org.haiyang.orderdemo.service;

import org.haiyang.orderdemo.dto.OrderRequestDto;
import org.haiyang.orderdemo.po.Order;

import java.util.List;

public interface OrderService {
    int checkStock(int productId);
    void createOrderAndPublishEvent(OrderRequestDto orderRequestDto);

    List<Order> getOrderById(int id);
}
