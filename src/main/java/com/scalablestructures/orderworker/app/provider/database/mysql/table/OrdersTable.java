package com.scalablestructures.orderworker.app.provider.database.mysql.table;

import com.scalablestructures.orderworker.domain.order.entity.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class OrdersTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_id")
    private Long customerId;

    @Column
    private LocalDateTime date;

    @Column
    private String status;

    @Column
    private Double value;

    @OneToMany(
        mappedBy = "order",
        fetch = FetchType.LAZY,
        cascade = {CascadeType.ALL})
    private List<OrdersItemsTable> items = new ArrayList<>();

    public OrdersTable fromDomain(OrderEntity orderEntity) {
        OrdersTable ordersTable = OrdersTable.builder()
            .customerId(orderEntity.getCustomer().getId())
            .date(orderEntity.getDate())
            .status(orderEntity.getStatus())
            .value(orderEntity.getAmount())
            .build();

        ordersTable.setItems(orderEntity.getItems().stream()
            .map(item -> new OrdersItemsTable().fromDomain(item, ordersTable))
            .collect(Collectors.toList()));

        return ordersTable;
    }
}
