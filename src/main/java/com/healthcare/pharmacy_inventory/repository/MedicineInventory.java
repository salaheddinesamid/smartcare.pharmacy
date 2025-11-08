package com.healthcare.pharmacy_inventory.repository;

import com.healthcare.pharmacy_inventory.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MedicineInventory extends JpaRepository<Medicine,Long> {

    boolean existsByReferenceNumber(String referenceNumber);
    Optional<Medicine> findByReferenceNumber(String ref);

    @Query("""
        SELECT m FROM Medicine m
        WHERE 
            (:name IS NULL OR LOWER(m.medicineName) LIKE LOWER(CONCAT('%', :name, '%')))
        OR 
            (:refNumber IS NULL OR LOWER(m.referenceNumber) LIKE LOWER(CONCAT('%', :refNumber, '%')))
    """)
    List<Medicine> searchMedicine(@Param("name") String name, @Param("refNumber") String refNumber);
}
