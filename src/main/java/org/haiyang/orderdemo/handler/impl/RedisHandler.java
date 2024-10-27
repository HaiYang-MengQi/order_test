package org.haiyang.orderdemo.handler.impl;

import org.haiyang.orderdemo.handler.OrderHandler;
import org.haiyang.orderdemo.po.OrderCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisHandler implements OrderHandler {
//    @Autowired
//    private RedisTemplate redisTemplate;
    //todo 哥，您要是能看到这里，这里有一个很奇怪的现象，我看bean工厂中明明有redisTemplate
    //todo 我注入@Autowired或者是直接工厂找到给它都是报null，求解？
//    DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
//    private RedisTemplate<String,Object> redisTemplate = (RedisTemplate<String,Object>)defaultListableBeanFactory.getBean("redisTemplate");
    @Override
    public void handle(OrderCreatedEvent event) {
//        redisTemplate.opsForValue().set(event.getOrderId(), event);
        System.out.println("订单持久化到redis");
    }
}
