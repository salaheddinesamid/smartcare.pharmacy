package com.healthcare.pharmacy_inventory.service.implementation;

import com.healthcare.pharmacy_inventory.dto.*;
import com.healthcare.pharmacy_inventory.exception.MedicineAlreadyExistsException;
import com.healthcare.pharmacy_inventory.exception.MedicineExpiredException;
import com.healthcare.pharmacy_inventory.exception.MedicineUnavailableException;
import com.healthcare.pharmacy_inventory.exception.PrescriptionRequiredException;
import com.healthcare.pharmacy_inventory.model.*;
import com.healthcare.pharmacy_inventory.repository.MedicineInventory;
import com.healthcare.pharmacy_inventory.repository.PurchaseItemRepository;
import com.healthcare.pharmacy_inventory.repository.PurchaseRepository;
import com.healthcare.pharmacy_inventory.service.PharmacyService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PharmacyServiceImpl implements PharmacyService {

    private final MedicineInventory medicineInventory;
    private final PurchaseRepository purchaseRepository;
    private final PurchaseItemRepository purchaseItemRepository;

    public PharmacyServiceImpl(MedicineInventory medicineInventory, PurchaseRepository purchaseRepository, PurchaseItemRepository purchaseItemRepository) {
        this.medicineInventory = medicineInventory;
        this.purchaseRepository = purchaseRepository;
        this.purchaseItemRepository = purchaseItemRepository;
    }

    @Override
    public MedicineResponseDto addNewMedicine(MedicineDto medicineDto) {
        if(medicineInventory.existsByReferenceNumber(medicineDto.getReferenceNumber())){
            throw new MedicineAlreadyExistsException();
        }
        Medicine medicine = new Medicine();
        medicine.setMedicineName(medicineDto.getMedicineName());
        medicine.setReferenceNumber(medicineDto.getReferenceNumber());
        medicine.setManufacturingDate(medicineDto.getManufacturingDate());
        medicine.setExpirationDate(medicineDto.getExpirationDate());
        medicine.setBatchNumber(medicineDto.getBatchNumber());
        medicine.setBrandName(medicine.getBrandName());
        medicine.setCategory(MedicineCategory.valueOf(medicineDto.getCategory()));
        medicine.setDosageForm(medicineDto.getDosageForm());
        medicine.setStrength(medicine.getStrength());
        medicine.setUnitPrice(medicineDto.getUnitPrice());
        medicine.setStorageTemperature(medicineDto.getStorageTemperature());
        medicine.setPrescriptionRequired(medicineDto.isPrescriptionRequired());
        medicine.setSupplierName(medicineDto.getSupplierName());
        medicine.setDescription(medicineDto.getDescription());
        medicine.setQuantity(medicineDto.getQuantity());
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

    @Override
    @Transactional
    public PurchaseResponseDto purchaseMedicine(PurchaseRequestDto purchaseRequestDto) {

        // Create new Purchase:
        Purchase purchase = new Purchase();
        purchase.setPatientId(purchaseRequestDto.getPatientId());

        //
        List<PurchaseItemRequestDto> items = purchaseRequestDto.getItems();

        // Process each item:
        List<PurchaseItem> purchaseItems =
                items.stream().map(this::processItem).toList();
        purchase.setItems(purchaseItems);
        purchase.setStatus(PurchaseStatus.PRELIMINARY);

        // save the purchase:
        Purchase savedPurchase = purchaseRepository.save(purchase);

        // Return a response:
        return new PurchaseResponseDto(
                savedPurchase
        );

    }

    /**
     * This method helper is used to process each item in the purchase:
     * @param item
     * @return a saved item in the database
     */
    private PurchaseItem processItem(PurchaseItemRequestDto item){

        String refNumber = item.getReferenceNumber();
        Integer quantity = item.getQuantity();
        // Check if the medicine exists:
        Medicine medicine = medicineInventory
                .findByReferenceNumber(refNumber)
                .orElseThrow();

        // Check if the medicine is not expired:
        boolean isExpired = medicine.getExpirationDate().isBefore(LocalDate.now());

        if(medicine.isPrescriptionRequired()){
            throw new PrescriptionRequiredException();
        }
        if(medicine.getStatus() == MedicineStatus.UNAVAILABLE){
            throw new MedicineUnavailableException(refNumber);
        }

        // if the medicine is expired the application throws and exception
        if(isExpired){
            throw new MedicineExpiredException(refNumber);
        }
        // Otherwise, make the purchase:
        // Reduce the quantity of the medicine:
        medicine.setQuantity(medicine.getQuantity() - quantity);
        medicineInventory.save(medicine);

        PurchaseItem purchaseItem = new PurchaseItem();
        purchaseItem.setMedicine(medicine);
        purchaseItem.setQuantity(quantity);

        return purchaseItemRepository.save(purchaseItem);


    }


    private void checkPrescriptionValidity(String prescriptionRef){

    }
}
