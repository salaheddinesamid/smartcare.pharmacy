package com.healthcare.pharmacy_inventory.dto;

import lombok.Data;

@Data
public class PurchaseItemRequestDto {

    private String referenceNumber;
    private Integer quantity;
}
