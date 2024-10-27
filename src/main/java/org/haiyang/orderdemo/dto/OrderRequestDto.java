package org.haiyang.orderdemo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderRequestDto {
    @NotNull
    @Positive
    private int userId;
    @NotNull
    @Positive
    private int productId;
    private int count;
}
