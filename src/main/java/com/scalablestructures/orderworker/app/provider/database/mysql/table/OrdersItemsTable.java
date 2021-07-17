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
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id")
    private OrdersTable order;

    @Column(name = "product_id")
    private Long productId;

    @Column
    private Integer quantity;

    @Column(name = "unit_value")
    private Double unitValue;

    public OrdersItemsTable fromDomain(OrderItemEntity orderItemEntity, OrdersTable order) {
        return OrdersItemsTable.builder()
            .order(order)
            .productId(orderItemEntity.getProduct().getId())
            .quantity(orderItemEntity.getQuantity())
            .unitValue(orderItemEntity.getUnitValue())
            .build();
    }
}
