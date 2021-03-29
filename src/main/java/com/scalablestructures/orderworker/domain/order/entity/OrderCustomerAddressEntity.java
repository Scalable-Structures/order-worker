package com.scalablestructures.orderworker.domain.order.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderCustomerAddressEntity {
    private String street;
    private Number number;
    private String neighborhood;
    private String zipcode;
    private String city;
    private String state;
    private String complement;
}
