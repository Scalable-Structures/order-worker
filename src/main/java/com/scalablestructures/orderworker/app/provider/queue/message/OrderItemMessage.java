package com.scalablestructures.orderworker.app.provider.queue.message;

import com.scalablestructures.orderworker.domain.order.entity.OrderItemEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItemMessage {
    private OrderItemProductMessage product;
    private Integer quantity;
    private Double unitValue;

    public OrderItemEntity toDomain(OrderItemMessage orderItemMessage) {
        return OrderItemEntity.builder()
            .product(new OrderItemProductMessage().toDomain(orderItemMessage.getProduct()))
            .quantity(orderItemMessage.getQuantity())
            .unitValue(orderItemMessage.getUnitValue())
            .build();
    }
}
