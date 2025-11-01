package com.healthcare.pharmacy_inventory.dto;

import com.healthcare.pharmacy_inventory.model.Purchase;
import com.healthcare.pharmacy_inventory.model.PurchaseItem;
import lombok.Data;

import java.util.List;

@Data
public class PurchaseResponseDto {

    private Integer patientId;
    private List<PurchaseItem> items;
    private String status;
    private String notes;

    public PurchaseResponseDto(Purchase purchase){
        this.patientId = purchase.getPatientId();
        this.items = purchase.getItems();
        this.status = purchase.getStatus();
    }
}
