package org.haiyang.orderdemo.po;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class OrderCreatedEvent {
    private  String orderId;
    private  int userId;
    private  int productId;
    private  int count;
    private LocalDateTime createTime;
}
