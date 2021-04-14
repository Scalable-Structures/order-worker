package com.scalablestructures.orderworker.domain.order.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItemEntity {
    private UUID id;
    private UUID orderId;
    private UUID productId;
    private Integer quantity;
    private Double unitValue;
}
