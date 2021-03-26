package com.scalablestructures.orderworker.domain.order.usecase.impl;

import com.scalablestructures.orderworker.domain.order.provider.OrderCreateProvider;
import com.scalablestructures.orderworker.domain.order.usecase.OrderCreateUseCase;

import javax.inject.Named;

@Named
public class OrderCreateUseCaseImpl implements OrderCreateUseCase {
    private final OrderCreateProvider orderCreateProvider;

    public OrderCreateUseCaseImpl(final OrderCreateProvider orderCreateProvider) {
        this.orderCreateProvider = orderCreateProvider;
    }

    @Override
    public void execute() {

    }
}
