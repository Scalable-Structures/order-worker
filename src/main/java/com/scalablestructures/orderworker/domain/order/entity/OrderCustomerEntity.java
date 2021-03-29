package com.scalablestructures.orderworker.domain.order.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderCustomerEntity {
    private UUID id;
    private String name;
    private Long document;
    private OrderCustomerAddressEntity address;
    private OrderCustomerPhoneEntity cellphone;
}
