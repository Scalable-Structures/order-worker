package com.scalablestructures.orderworker.domain.order.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderEntity {
    private UUID id;
    private OrderCustomerEntity customer;
    private Date date;
    private Boolean status;
    private Double value;
    private List<OrderItemEntity> items;
}
