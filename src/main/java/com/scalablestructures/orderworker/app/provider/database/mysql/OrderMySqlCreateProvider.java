package com.scalablestructures.orderworker.app.provider.database.mysql;

import com.scalablestructures.orderworker.app.provider.database.mysql.repository.OrderRepository;
import com.scalablestructures.orderworker.app.provider.database.mysql.table.OrdersTable;
import com.scalablestructures.orderworker.domain.order.entity.OrderEntity;
import com.scalablestructures.orderworker.domain.order.gateway.OrderCreateGateway;

import javax.inject.Named;

@Named("OrderMySqlCreateProvider")
public class OrderMySqlCreateProvider implements OrderCreateGateway {

    private final OrderRepository orderRepository;

    public OrderMySqlCreateProvider(final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void create(OrderEntity order) {
        OrdersTable ordersTable = new OrdersTable().fromDomain(order);

        this.orderRepository.save(ordersTable);
    }
}
