package com.scalablestructures.orderworker.domain.order.entity;

import com.scalablestructures.orderworker.domain.customer.entity.CustomerEntity;
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
    private CustomerEntity customer;
    private Date date;
    private String status;
    private Double value;
    private List<OrderItemEntity> items;
}
