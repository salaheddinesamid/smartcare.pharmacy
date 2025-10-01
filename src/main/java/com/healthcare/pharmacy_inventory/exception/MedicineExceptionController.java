package com.healthcare.pharmacy_inventory.exception;

import com.healthcare.pharmacy_inventory.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MedicineExceptionController {

    @ExceptionHandler(MedicineAlreadyExistsException.class)
    public ResponseEntity<ApiResponse<?>> handleMedicineAlreadyExists(MedicineAlreadyExistsException e){

        ApiResponse<?> response = new ApiResponse<>(
                false,
                "This medicine already exists",
                null
        );

        return ResponseEntity
                .status(409)
                .body(response);
    }
}
