package com.scalablestructures.orderworker.domain.order.usecase.impl;

import com.scalablestructures.orderworker.domain.order.entity.OrderEntity;
import com.scalablestructures.orderworker.domain.order.provider.OrderCreateProvider;
import com.scalablestructures.orderworker.domain.order.usecase.OrderCreateUseCase;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.inject.Named;

@Log4j2
@Named
public class OrderCreateUseCaseImpl implements OrderCreateUseCase {
    private final OrderCreateProvider orderCreateProvider;

    public OrderCreateUseCaseImpl(@Qualifier("OrderMySqlCreateProviderImpl") final OrderCreateProvider orderCreateProvider) {
        this.orderCreateProvider = orderCreateProvider;
    }

    @Override
    public void execute(OrderEntity order) {
        log.info("Start saving order {}", order);
        this.orderCreateProvider.create(order);
    }
}
