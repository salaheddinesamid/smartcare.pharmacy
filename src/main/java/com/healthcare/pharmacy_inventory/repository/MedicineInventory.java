package com.healthcare.pharmacy_inventory.repository;

import com.healthcare.pharmacy_inventory.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedicineInventory extends JpaRepository<Medicine,Integer> {

    boolean existsByReferenceNumber(String referenceNumber);
    Optional<Medicine> findByReferenceNumber(String ref);
}
