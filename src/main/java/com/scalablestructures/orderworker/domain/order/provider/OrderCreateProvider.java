package com.scalablestructures.orderworker.domain.order.provider;

import com.scalablestructures.orderworker.domain.order.entity.OrderEntity;

public interface OrderCreateProvider {
    void create(OrderEntity order);
}
