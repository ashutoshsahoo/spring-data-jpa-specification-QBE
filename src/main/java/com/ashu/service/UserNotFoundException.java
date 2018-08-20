package com.ashu.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 8533016420446077553L;

    public UserNotFoundException(Long id) {
	super("User not found for requested id:'" + id + "'.");
    }
}
