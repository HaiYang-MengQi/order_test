package org.haiyang.orderdemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.haiyang.orderdemo.dto.OrderRequestDto;
import org.haiyang.orderdemo.po.Results;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class LockAspect {
    @Autowired
    private RedissonClient redissonClient;

    @Around("@annotation(org.haiyang.orderdemo.anno.Locked) && args(orderRequestDTO)")
    public Object around(ProceedingJoinPoint joinPoint, OrderRequestDto orderRequestDTO) throws Throwable {

        String lockKey = "order_lock:" + orderRequestDTO.getUserId() + ":" + orderRequestDTO.getProductId();
        RLock lock = redissonClient.getLock(lockKey);
        boolean isLock = lock.tryLock(1, 3, TimeUnit.SECONDS);
        if (!isLock) return Results.error("其他已经在处理了");
        try {
            TimeUnit.SECONDS.sleep(3    );
            return joinPoint.proceed();
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock(); // 确保释放锁
            }
        }
    }
}

