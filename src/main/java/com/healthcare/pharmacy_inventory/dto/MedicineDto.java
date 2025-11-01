package com.healthcare.pharmacy_inventory.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MedicineDto {
    private String referenceNumber;
    private String name;
    private LocalDate manufacturingDate;
    private LocalDate expirationDate;
}

