package org.haiyang.orderdemo.dao;

import org.haiyang.orderdemo.po.Order;

import java.util.List;

public interface OrderMapper {
    int checkStock(int productId);
     List<Order> getOrderById(int orderId);
}
