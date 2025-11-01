package com.healthcare.pharmacy_inventory.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class PurchaseItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer itemId;

    @JoinColumn(name = "medicine_id")
    @ManyToOne
    Medicine medicine;

    @Column(name = "quantity")
    private Integer quantity;
}
