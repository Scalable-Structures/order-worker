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
@Table(name = "order_item")
public class OrderItemTable {
    @Id
    private UUID id = UUID.randomUUID();

    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinColumn(name = "order_id", nullable = false)
    private OrderTable order;

    @Column(name = "product_id")
    private UUID productId;

    @Column
    private Integer quantity;

    @Column(name = "unit_value")
    private Double unitValue;

    public OrderItemTable fromDomain(UUID orderId, OrderItemEntity orderItemEntity) {
        return OrderItemTable.builder()
            .id(id)
            .order(OrderTable.builder().id(orderId).build())
            .productId(orderItemEntity.getProductId())
            .quantity(orderItemEntity.getQuantity())
            .unitValue(orderItemEntity.getUnitValue())
            .build();
    }
}
