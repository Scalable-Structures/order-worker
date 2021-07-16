package com.scalablestructures.orderworker.app.provider.database.mysql.table;

import com.scalablestructures.orderworker.domain.order.entity.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class OrdersTable {
    @Id
    private String id = UUID.randomUUID().toString();

    @Column(name = "customer_id")
    private String customerId;

    @Column
    private LocalDateTime date;

    @Column
    private String status;

    @Column
    private Double amount;

    @OneToMany(
        mappedBy = "order",
        fetch = FetchType.LAZY,
        cascade = {CascadeType.MERGE,
            CascadeType.PERSIST})
    private List<OrdersItemsTable> items;

    public OrdersTable fromDomain(OrderEntity orderEntity) {
        return OrdersTable.builder()
            .id(id)
            .customerId(orderEntity.getCustomer().getId())
            .date(orderEntity.getDate())
            .status(orderEntity.getStatus())
            .amount(orderEntity.getAmount())
            .items(
                orderEntity.getItems().stream()
                    .map(item -> new OrdersItemsTable().fromDomain(id, item))
                    .collect(Collectors.toList()))
            .build();
    }
}
