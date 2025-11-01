package com.healthcare.pharmacy_inventory.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "medicines")
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medicineId;

    @Column(name = "reference_number", nullable = false, unique = true)
    private String referenceNumber;

    @Column(name = "medicine_name", nullable = false)
    private String medicineName;

    @Column(name = "brand_name")
    private String brandName;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private MedicineCategory category; // e.g., Antibiotic, Analgesic, Antipyretic

    @Column(name = "dosage_form")
    private String dosageForm; // e.g., Tablet, Capsule, Syrup

    @Column(name = "strength")
    private String strength; // e.g., 500mg, 250mg/5ml

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "unit_price")
    private Double unitPrice;

    @Column(name = "batch_number", unique = true)
    private String batchNumber;

    @Column(name = "manufacturing_date")
    private LocalDate manufacturingDate;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @Column(name = "supplier_name")
    private String supplierName;

    @Column(name = "storage_temperature")
    private String storageTemperature; // e.g., "2°C–8°C" or "Room temperature"

    @Column(name = "prescription_required")
    private boolean prescriptionRequired;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private MedicineStatus status;

    @Column(name = "description", length = 1000)
    private String description;

    // === Audit Columns ===
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
