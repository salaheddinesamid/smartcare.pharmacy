package com.healthcare.pharmacy_inventory.unit;

import com.healthcare.pharmacy_inventory.repository.MedicineInventory;
import com.healthcare.pharmacy_inventory.repository.PurchaseItemRepository;
import com.healthcare.pharmacy_inventory.repository.PurchaseRepository;
import com.healthcare.pharmacy_inventory.service.implementation.PharmacyServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PharmacyServiceUnitTest {

    @Mock
    private MedicineInventory medicineInventory;

    @Mock
    private PurchaseItemRepository purchaseItemRepository;

    @Mock
    private PurchaseRepository purchaseRepository;

    @InjectMocks
    private PharmacyServiceImpl pharmacyService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }


}
