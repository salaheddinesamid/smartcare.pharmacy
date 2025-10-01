package com.healthcare.pharmacy_inventory.controller;

import com.healthcare.pharmacy_inventory.dto.ApiResponse;
import com.healthcare.pharmacy_inventory.dto.MedicineDto;
import com.healthcare.pharmacy_inventory.dto.MedicineResponseDto;
import com.healthcare.pharmacy_inventory.service.implementation.PharmacyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pharmacy")
public class PharmacyInventoryController {

    private final PharmacyServiceImpl pharmacyService;

    @Autowired
    public PharmacyInventoryController(PharmacyServiceImpl pharmacyService) {
        this.pharmacyService = pharmacyService;
    }

    @PostMapping("add-medicine")
    public ResponseEntity<ApiResponse<?>> addNewMedicine(@RequestBody MedicineDto medicineDto){

        MedicineResponseDto medicine = pharmacyService.addNewMedicine(medicineDto);

        ApiResponse<MedicineResponseDto> response = new ApiResponse<>(
                true,
                "The medicine has been added successfully",
                medicine
        );

        return ResponseEntity
                .status(200)
                .body(response);
    }
}
