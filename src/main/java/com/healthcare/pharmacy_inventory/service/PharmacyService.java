package com.healthcare.pharmacy_inventory.service;

import com.healthcare.pharmacy_inventory.dto.MedicineDto;
import com.healthcare.pharmacy_inventory.dto.MedicineResponseDto;

public interface PharmacyService {


    /**
     * This function is responsible for adding new medicines to the inventory
     * @param medicineDto
     * @return
     */
    MedicineResponseDto addNewMedicine(MedicineDto medicineDto);
}
