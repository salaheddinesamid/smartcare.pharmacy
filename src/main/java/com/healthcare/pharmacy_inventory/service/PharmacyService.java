package com.healthcare.pharmacy_inventory.service;

import com.healthcare.pharmacy_inventory.dto.MedicineDto;
import com.healthcare.pharmacy_inventory.dto.MedicineResponseDto;
import com.healthcare.pharmacy_inventory.dto.PurchaseRequestDto;
import com.healthcare.pharmacy_inventory.dto.PurchaseResponseDto;

import java.util.List;

public interface PharmacyService {


    /**
     * This function is responsible for adding new medicines to the inventory
     * @param medicineDto
     * @return
     */
    MedicineResponseDto addNewMedicine(MedicineDto medicineDto);

    /**
     * This function fetches the medicines that exists in the system
     * @return
     */
    List<MedicineResponseDto> getAllMedicines();

    /**
     * This method handles patient orders
     * @param purchaseRequestDto
     * @return
     */
    PurchaseResponseDto purchaseMedicine(PurchaseRequestDto purchaseRequestDto);

    /**
     *
     * @param medicineId
     */
    void removeMedicine(Long medicineId);

    /**
     * This function handles medicine status update
     * @param status
     */
    void updateMedicineStatus(Long id, String status);

    /**
     *
     * @param id
     * @param newQuantity
     */
    void updateQuantity(Long id, Integer newQuantity);

    /**
     * This function handles medicine search by name or ref number
     * @param name
     * @param refNumber
     * @return
     */
    List<MedicineResponseDto> searchMedicine(String name, String refNumber);
}
