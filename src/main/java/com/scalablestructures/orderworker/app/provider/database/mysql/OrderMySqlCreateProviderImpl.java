package com.scalablestructures.orderworker.app.provider.database.mysql;

import com.scalablestructures.orderworker.app.provider.database.mysql.repository.OrderRepository;
import com.scalablestructures.orderworker.app.provider.database.mysql.table.OrderTable;
import com.scalablestructures.orderworker.domain.order.entity.OrderEntity;
import com.scalablestructures.orderworker.domain.order.provider.OrderCreateProvider;

import javax.inject.Named;

@Named("OrderMySqlCreateProviderImpl")
public class OrderMySqlCreateProviderImpl implements OrderCreateProvider {

    private final OrderRepository orderRepository;

    public OrderMySqlCreateProviderImpl(final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void create(OrderEntity order) {
        this.orderRepository.save(new OrderTable().fromDomain(order));
    }
}
