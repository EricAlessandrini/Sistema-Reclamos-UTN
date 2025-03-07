package com.ega.reclamos.domain.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskNotFoundException extends RuntimeException {

    private String title;

    public TaskNotFoundException(String message) {
        super(message);
        this.title = "TASK NOT FOUND";
    }
}
