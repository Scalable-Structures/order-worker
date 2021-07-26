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
    private Long id;
    private Long orderId;
    private OrderItemProductEntity product;
    private Integer quantity;
    private Double unitValue;
}
