package com.scalablestructures.orderworker.app.provider.queue.message;

import com.scalablestructures.orderworker.domain.order.entity.OrderCustomerEntity;
import com.scalablestructures.orderworker.domain.order.entity.OrderItemProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItemProductMessage {
    private String id;

    public OrderItemProductEntity toDomain(OrderItemProductMessage orderItemProductMessage) {
        return OrderItemProductEntity.builder()
            .id(orderItemProductMessage.getId())
            .build();
    }
}
