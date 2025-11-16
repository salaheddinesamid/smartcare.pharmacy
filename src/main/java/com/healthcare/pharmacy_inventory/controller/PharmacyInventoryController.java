package com.healthcare.pharmacy_inventory.controller;

import com.healthcare.pharmacy_inventory.dto.*;
import com.healthcare.pharmacy_inventory.service.implementation.PharmacyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/pharmacy")
public class PharmacyInventoryController {

    private final PharmacyServiceImpl pharmacyService;

    @Autowired
    public PharmacyInventoryController(PharmacyServiceImpl pharmacyService) {
        this.pharmacyService = pharmacyService;
    }

    @PostMapping("medicines/add")
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

    @GetMapping("medicines/get_all")
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

    @PostMapping("medicines/purchase")
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

    @PutMapping("medicines/update-quantity")
    public ResponseEntity<ApiResponse<?>> updateQuantity(@RequestParam Long medicineId, @RequestParam Integer newQuantity){

        pharmacyService.updateQuantity(medicineId,newQuantity);
        return ResponseEntity
                .status(200)
                .body(new ApiResponse<>(
                        true,
                        "The new medicine has been successfully updated",
                        null
                ));
    }

    @GetMapping("medicines/search")
    public ResponseEntity<ApiResponse<?>> search(@RequestParam(required = false) String name, @RequestParam(required = false) String refNumber){

        List<MedicineResponseDto> medicines = pharmacyService.searchMedicine(name,refNumber);

        return ResponseEntity
                .status(200)
                .body(new ApiResponse<>(
                        true,
                        "",
                        medicines
                ));
    }

    @PutMapping("medicines/suspend")
    public ResponseEntity<?> suspend(@RequestParam Long medicineId){
        // Act:
        pharmacyService.suspendMedicine(medicineId);

        return ResponseEntity
                .status(200)
                .body(Map.of("message","The medicine has been suspended successfully"));
    }
}
