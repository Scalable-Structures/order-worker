package com.scalablestructures.orderworker.app.provider.queue.message;

import com.scalablestructures.orderworker.domain.order.entity.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderMessage {
    private OrderCustomerMessage customer;
    private String date;
    private String status;
    private Double amount;
    private List<OrderItemMessage> items;

    public OrderEntity toDomain(OrderMessage orderMessage) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime formattedDate = LocalDateTime.parse(orderMessage.getDate(), dateTimeFormatter);

        return OrderEntity.builder()
            .customer(new OrderCustomerMessage().toDomain(orderMessage.getCustomer()))
            .date(formattedDate)
            .status(orderMessage.getStatus())
            .amount(orderMessage.getAmount())
            .items(
                orderMessage.getItems().stream()
                    .map(item -> new OrderItemMessage().toDomain(item))
                    .collect(Collectors.toList()))
            .build();
    }
}
