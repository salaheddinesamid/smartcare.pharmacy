package com.healthcare.pharmacy_inventory.unit;

import com.healthcare.pharmacy_inventory.repository.MedicineInventory;
import com.healthcare.pharmacy_inventory.service.implementation.PharmacyServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PharmacyServiceUnitTest {

    @Mock
    private MedicineInventory medicineInventory;

    @InjectMocks
    private PharmacyServiceImpl pharmacyService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddMedicineSuccessfully(){}

    @Test
    void testAddMedicineThrowMedicineAlreadyExists(){}

    @Test
    void testPurchaseMedicineSuccess(){}

    @Test
    void testPurchaseMedicineThrowMedicineUnavailable(){}

}
