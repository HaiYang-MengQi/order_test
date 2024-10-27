//package org.haiyang.orderdemo.task;
//
//import org.haiyang.orderdemo.po.OrderCreatedEvent;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.time.Duration;
//import java.time.LocalDateTime;
//import java.util.Set;
//
//@Component
//public class OrderTimeoutTask {
//
//    @Autowired
//    private RedisTemplate<String, Object> redisTemplate;
//
//    // 定时任务，每分钟执行一次
//    @Scheduled(fixedRate = 60000) // 60000毫秒 = 1分钟
//    public void checkAndRemoveExpiredOrders() {
//        Set<String> keys = redisTemplate.keys("order:*");
//        if (keys != null) {
//            for (String key : keys) {
//                OrderCreatedEvent event = (OrderCreatedEvent) redisTemplate.opsForValue().get(key);
//                if (event != null) {
//                    LocalDateTime currentTime = LocalDateTime.now();
//                    Duration duration = Duration.between(event.getCreateTime(), currentTime);
//                    if (!duration.isNegative()) {
//                        redisTemplate.delete(key);
//                        System.out.println("订单超时，已从 Redis 移除: " + key);
//                    }
//                }
//            }
//        }
//    }
//}
