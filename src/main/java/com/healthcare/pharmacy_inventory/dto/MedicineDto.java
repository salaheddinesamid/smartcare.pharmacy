package com.healthcare.pharmacy_inventory.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class MedicineDto {
    private Long medicineId;
    private String referenceNumber;
    private String medicineName;
    private String brandName;
    private String category;             // e.g., Antibiotic, Painkiller
    private String dosageForm;           // e.g., Tablet, Syrup
    private String strength;             // e.g., 500mg
    private Integer quantity;
    private Double unitPrice;
    private String batchNumber;
    private LocalDate manufacturingDate;
    private LocalDate expirationDate;
    private String supplierName;
    private String storageTemperature;
    private boolean prescriptionRequired;
    private String status;               // You can map from MedicineStatus enum
    private String description;
}
