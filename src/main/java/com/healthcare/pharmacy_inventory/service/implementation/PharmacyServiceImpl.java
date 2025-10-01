package com.healthcare.pharmacy_inventory.service.implementation;

import com.healthcare.pharmacy_inventory.dto.MedicineDto;
import com.healthcare.pharmacy_inventory.dto.MedicineResponseDto;
import com.healthcare.pharmacy_inventory.exception.MedicineAlreadyExistsException;
import com.healthcare.pharmacy_inventory.model.Medicine;
import com.healthcare.pharmacy_inventory.model.MedicineStatus;
import com.healthcare.pharmacy_inventory.repository.MedicineInventory;
import com.healthcare.pharmacy_inventory.service.PharmacyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacyServiceImpl implements PharmacyService {

    private final MedicineInventory medicineInventory;

    public PharmacyServiceImpl(MedicineInventory medicineInventory) {
        this.medicineInventory = medicineInventory;
    }

    @Override
    public MedicineResponseDto addNewMedicine(MedicineDto medicineDto) {
        if(medicineInventory.existsByReferenceNumber(medicineDto.getReferenceNumber())){
            throw new MedicineAlreadyExistsException();
        }
        Medicine medicine = new Medicine();
        medicine.setMedicineName(medicineDto.getName());
        medicine.setReferenceNumber(medicineDto.getReferenceNumber());
        medicine.setManufacturingDate(medicineDto.getManufacturingDate());
        medicine.setExpirationDate(medicineDto.getExpirationDate());
        medicine.setStatus(MedicineStatus.REGISTERED);

        // Save the medicine
        Medicine savedMedicine = medicineInventory.save(medicine);
        return new MedicineResponseDto(
                savedMedicine
        );
    }

    @Override
    public List<MedicineResponseDto> getAllMedicines() {

        // Fetch medicines from the db
        List<Medicine> medicines = medicineInventory.findAll();
        return
                medicines.stream()
                        .map(MedicineResponseDto::new)
                        .toList();
    }
}
