package com.healthcare.pharmacy_inventory.exception;

import com.healthcare.pharmacy_inventory.dto.ApiResponse;
import org.apache.coyote.Response;
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


    @ExceptionHandler(MedicineExpiredException.class)
    public ResponseEntity<ApiResponse<?>> handleExpiredMedicine(MedicineExpiredException ex){
        ApiResponse<?> response = new ApiResponse<>(
                false,
                ex.getMessage(),
                null
        );

        return ResponseEntity
                .status(409)
                .body(response);
    }

    @ExceptionHandler(PrescriptionRequiredException.class)
    public ResponseEntity<ApiResponse<?>> handlePrescriptionRequirement(){
        ApiResponse<?> response = new ApiResponse<>(
                false,
                "The medicine requires a medical prescription",
                null
        );
        return ResponseEntity
                .status(409)
                .body(response);
    }
}
