package com.eakkas.citizenprojectapp.exception;

import lombok.Getter;

@Getter

public class CitizenProjectException extends RuntimeException {

    private final ErrorType errorType;

    public CitizenProjectException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public CitizenProjectException(ErrorType errorType, String customMessage) {
        super(customMessage);
        this.errorType = errorType;
    }
}
