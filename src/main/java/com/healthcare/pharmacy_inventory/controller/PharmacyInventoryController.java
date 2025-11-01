package com.healthcare.pharmacy_inventory.controller;

import com.healthcare.pharmacy_inventory.dto.*;
import com.healthcare.pharmacy_inventory.service.implementation.PharmacyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("get_all")
    public ResponseEntity<ApiResponse<?>> getAllMedicine(){

        List<MedicineResponseDto> medicines = pharmacyService.getAllMedicines();

        return ResponseEntity
                .status(200)
                .body(new ApiResponse<>(
                        true,
                        "",
                        medicines
                ));
    }

    @PostMapping("purchase")
    public ResponseEntity<ApiResponse<?>> purchase(@RequestBody PurchaseRequestDto request){

        PurchaseResponseDto purchaseResponse = pharmacyService.purchaseMedicine(request);

        ApiResponse<?> response = new ApiResponse<>(
                true,
                "Purchase completed successfully",
                purchaseResponse
        );

        return ResponseEntity
                .status(200)
                .body(response);

    }
}
