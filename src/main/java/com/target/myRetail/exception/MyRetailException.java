package com.target.myRetail.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
public class MyRetailException extends Exception implements Serializable {

    private String errorMessage = " Something went wrong.. \n please contact administrator";

    private HttpStatus httpStatus;

    private Throwable cause;

    public MyRetailException() {
        super();
    }

    public MyRetailException(String errMsg) {
        super(errMsg);
        this.errorMessage = errMsg;
    }

    public MyRetailException(String errorMessage, HttpStatus httpStatus) {
        super(errorMessage);
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
    }

    public MyRetailException(String errorMessage, HttpStatus httpStatus, Throwable cause) {
        super(errorMessage, cause);
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
        this.cause = cause;
    }

}