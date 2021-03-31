package com.scalablestructures.orderworker.domain.order.entity;

import com.scalablestructures.orderworker.domain.product.entity.ProductEntity;
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
    private OrderEntity order;
    private ProductEntity product;
    private Integer quantity;
    private Double unitValue;
}
