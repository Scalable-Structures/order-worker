package com.scalablestructures.orderworker.app.provider.database.mysql.table;

import com.scalablestructures.orderworker.domain.order.entity.OrderItemEntity;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "orders_items")
public class OrdersItemsTable {
    @Id
    private String id = UUID.randomUUID().toString();

    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinColumn(name = "order_id", nullable = false)
    private OrdersTable order;

    @Column(name = "product_id")
    private String productId;

    @Column
    private Integer quantity;

    @Column(name = "unit_value")
    private Double unitValue;

    public OrdersItemsTable fromDomain(String orderId, OrderItemEntity orderItemEntity) {
        return OrdersItemsTable.builder()
            .id(id)
            .order(OrdersTable.builder().id(orderId).build())
            .productId(orderItemEntity.getProduct().getId())
            .quantity(orderItemEntity.getQuantity())
            .unitValue(orderItemEntity.getUnitValue())
            .build();
    }
}
