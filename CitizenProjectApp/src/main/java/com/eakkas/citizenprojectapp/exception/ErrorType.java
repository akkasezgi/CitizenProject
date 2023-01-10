package com.eakkas.citizenprojectapp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ErrorType {

    BAD_REQUEST_ERROR(5000, "Wrong parameter", HttpStatus.BAD_REQUEST),
    CITIZEN_NOT_FOUND(1000, "The citizen you are looking for is not registered in the system.", HttpStatus.INTERNAL_SERVER_ERROR),
    VALUE_NOT_FOUND_IN_CITIZEN(1001, "The data you are looking for is not found in usernames", HttpStatus.INTERNAL_SERVER_ERROR),
    CHILDREN_NOT_FOUND(1002, "The children you are looking for is not registered in the system.", HttpStatus.INTERNAL_SERVER_ERROR),
    CITIZEN_NOT_CREATED(1003, "The citizen you want to register could not be created.", HttpStatus.INTERNAL_SERVER_ERROR),
    UNAUTHORIZED_REQUEST(1004,"Unauthorized login attempt",HttpStatus.INTERNAL_SERVER_ERROR);


    private int code;
    private String message;
    HttpStatus httpStatus;
}
