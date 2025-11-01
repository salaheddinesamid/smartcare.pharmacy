package com.healthcare.pharmacy_inventory.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer purchaseId;

    @OneToMany
    List<PurchaseItem> items;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private PurchaseStatus status;

    @Column(name = "patient_id")
    private Integer patientId;

}
