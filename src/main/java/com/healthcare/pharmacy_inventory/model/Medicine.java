package com.healthcare.pharmacy_inventory.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer medicineId;

    @Column(name = "reference_number")
    private String referenceNumber;

    @Column(name = "medicine_name")
    private String medicineName;

    @Column(name = "manufacturing_date")
    private LocalDate manufacturingDate;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private MedicineStatus status;
}
