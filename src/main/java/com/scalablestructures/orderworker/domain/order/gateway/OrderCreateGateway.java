package com.scalablestructures.orderworker.domain.order.gateway;

import com.scalablestructures.orderworker.domain.order.entity.OrderEntity;

public interface OrderCreateGateway {
    void create(OrderEntity order);
}
