package com.f1soft.testcrud.exception;

import com.f1soft.testcrud.error.ErrorResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataNotFoundException extends RuntimeException {
    private ErrorResponse errorResponse;

    public DataNotFoundException(String message) {
        super(message);
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrormsg(message);
    }
}
