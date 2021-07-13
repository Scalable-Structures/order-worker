package com.scalablestructures.orderworker.domain.order.interactor;

import com.scalablestructures.orderworker.domain.order.entity.OrderEntity;

public interface OrderCreateInteractor {
    void execute(OrderEntity order);
}
