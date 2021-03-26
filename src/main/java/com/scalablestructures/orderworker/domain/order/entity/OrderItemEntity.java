package com.scalablestructures.orderworker.domain.order.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItemEntity {
    private OrderProductEntity product;
    private Double unitValue;
    private Integer quantity;
}
