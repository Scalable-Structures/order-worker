package com.scalablestructures.orderworker.domain.order.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderEntity {
    private String id;
    private OrderCustomerEntity customer;
    private LocalDateTime date;
    private String status;
    private Double value;
    private List<OrderItemEntity> items;
}
