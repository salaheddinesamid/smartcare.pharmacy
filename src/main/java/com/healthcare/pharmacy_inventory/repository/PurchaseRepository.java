package com.healthcare.pharmacy_inventory.repository;

import com.healthcare.pharmacy_inventory.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
