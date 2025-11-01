package com.healthcare.pharmacy_inventory.exception;

public class MedicineExpiredException extends RuntimeException{

    public MedicineExpiredException(String ref){
        super(String.format("This medicine is expired. Ref N:%s",ref));
    }
}
