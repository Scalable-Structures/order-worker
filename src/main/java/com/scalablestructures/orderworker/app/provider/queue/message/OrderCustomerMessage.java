package com.scalablestructures.orderworker.app.provider.queue.message;

import com.scalablestructures.orderworker.domain.order.entity.OrderCustomerEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderCustomerMessage {
    private Long id;

    public OrderCustomerEntity toDomain(OrderCustomerMessage orderCustomerMessage) {
        return OrderCustomerEntity.builder()
            .id(orderCustomerMessage.getId())
            .build();
    }
}
