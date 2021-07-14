package com.scalablestructures.orderworker.app.provider.database.mysql.table;

import com.scalablestructures.orderworker.domain.order.entity.OrderEntity;
import com.scalablestructures.orderworker.domain.order.entity.OrderItemEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "order")
public class OrderTable {
    @Id
    private UUID id = UUID.randomUUID();

    @Column(name = "customer_id")
    private UUID customerId;

    @Column
    private Date date;

    @Column
    private Boolean status;

    @Column
    private Double value;

    @OneToMany(
        mappedBy = "order",
        fetch = FetchType.LAZY,
        cascade = {CascadeType.MERGE,
            CascadeType.PERSIST})
    private List<OrderItemTable> items;

    public OrderTable fromDomain(OrderEntity orderEntity) {
        return OrderTable.builder()
            .id(id)
            .customerId(orderEntity.getCustomer().getId())
            .date(orderEntity.getDate())
            .status(orderEntity.getStatus())
            .value(orderEntity.getValue())
            .items(
                orderEntity.getItems().stream()
                    .map(item -> new OrderItemTable().fromDomain(id, item))
                    .collect(Collectors.toList()))
            .build();
    }
}
