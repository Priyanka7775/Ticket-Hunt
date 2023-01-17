package com.project.authentication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "user already exists")
public class UserAlreadyExistsException extends Exception {
}
