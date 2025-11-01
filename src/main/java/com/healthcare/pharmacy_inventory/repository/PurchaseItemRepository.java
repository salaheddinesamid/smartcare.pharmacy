package com.healthcare.pharmacy_inventory.repository;

import com.healthcare.pharmacy_inventory.model.PurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseItemRepository extends JpaRepository<PurchaseItem, Long> {
}
