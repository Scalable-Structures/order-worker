package com.scalablestructures.orderworker.app.provider.queue.message;

import com.scalablestructures.orderworker.domain.order.entity.OrderItemProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItemProductMessage {
    private Long id;

    public OrderItemProductEntity toDomain(OrderItemProductMessage orderItemProductMessage) {
        return OrderItemProductEntity.builder()
            .id(orderItemProductMessage.getId())
            .build();
    }
}
