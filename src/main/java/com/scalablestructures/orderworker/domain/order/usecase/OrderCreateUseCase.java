package com.scalablestructures.orderworker.domain.order.usecase;

import com.scalablestructures.orderworker.domain.order.entity.OrderEntity;
import com.scalablestructures.orderworker.domain.order.gateway.OrderCreateGateway;
import com.scalablestructures.orderworker.domain.order.interactor.OrderCreateInteractor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.inject.Named;

@Log4j2
@Named
public class OrderCreateUseCase implements OrderCreateInteractor {
    private final OrderCreateGateway orderCreateGateway;

    public OrderCreateUseCase(@Qualifier("OrderMySqlCreateProvider") final OrderCreateGateway orderCreateGateway) {
        this.orderCreateGateway = orderCreateGateway;
    }

    @Override
    public void execute(OrderEntity order) {
        log.info("Start saving order {}", order);
        this.orderCreateGateway.create(order);
    }
}
