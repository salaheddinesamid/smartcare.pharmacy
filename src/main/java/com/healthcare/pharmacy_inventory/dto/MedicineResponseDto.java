package com.healthcare.pharmacy_inventory.dto;

import com.healthcare.pharmacy_inventory.model.Medicine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicineResponseDto {

    private Long medicineId;
    private String referenceNumber;
    private String medicineName;
    private LocalDate manufacturingDate;
    private LocalDate expirationDate;
    private String status;
    public MedicineResponseDto(Medicine medicine){
        this.medicineId = medicine.getMedicineId();
        this.medicineName = medicine.getMedicineName();
        this.referenceNumber = medicine.getReferenceNumber();
        this.manufacturingDate = medicine.getManufacturingDate();
        this.expirationDate = medicine.getExpirationDate();
        this.status = medicine.getStatus().toString();
    }
}
