package com.healthcare.pharmacy_inventory.repository;

import com.healthcare.pharmacy_inventory.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineInventory extends JpaRepository<Medicine,Integer> {

    boolean existsByReferenceNumber(String referenceNumber);
}
