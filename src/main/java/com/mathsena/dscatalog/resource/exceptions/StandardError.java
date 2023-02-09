package com.mathsena.dscatalog.resource.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;


@Getter
@Setter
public class StandardError extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public StandardError(){

    }

}
