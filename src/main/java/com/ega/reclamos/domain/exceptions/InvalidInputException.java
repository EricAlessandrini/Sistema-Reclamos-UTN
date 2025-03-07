package com.ega.reclamos.domain.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvalidInputException extends RuntimeException {
    private String title;

    public InvalidInputException(String message) {
        super(message);
        this.title = "INVALID ID";
    }
}
