package com.healthcare.pharmacy_inventory.dto;

import lombok.Data;

import java.util.List;

@Data
public class PurchaseRequestDto {

    private Integer patientId;
    private List<PurchaseItemRequestDto> items;
}
