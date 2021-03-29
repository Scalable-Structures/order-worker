package com.scalablestructures.orderworker.domain.order.usecase;

import com.scalablestructures.orderworker.domain.order.entity.OrderEntity;

public interface OrderCreateUseCase {
    void execute(OrderEntity order);
}
