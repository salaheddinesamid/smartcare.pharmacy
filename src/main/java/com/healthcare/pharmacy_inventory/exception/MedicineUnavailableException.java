package com.healthcare.pharmacy_inventory.exception;

public class MedicineUnavailableException extends RuntimeException{

    public MedicineUnavailableException(String ref) {
        super(String.format("The medicine with Ref N:%s is unavailable",ref));
    }
}
