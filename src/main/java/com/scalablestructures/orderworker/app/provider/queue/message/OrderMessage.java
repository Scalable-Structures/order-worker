package com.scalablestructures.orderworker.app.provider.queue.message;

import com.scalablestructures.orderworker.domain.order.entity.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderMessage {
    private OrderCustomerMessage customer;
    private Date date;
    private Boolean status;
    private Double value;
    private List<OrderItemMessage> items;

    public OrderEntity toDomain(OrderMessage orderMessage) {
        return OrderEntity.builder()
            .customer(new OrderCustomerMessage().toDomain(orderMessage.getCustomer()))
            .date(orderMessage.getDate())
            .status(orderMessage.getStatus())
            .value(orderMessage.getValue())
            .items(
                orderMessage.getItems().stream()
                    .map(item -> new OrderItemMessage().toDomain(item))
                    .collect(Collectors.toList()))
            .build();
    }
}
