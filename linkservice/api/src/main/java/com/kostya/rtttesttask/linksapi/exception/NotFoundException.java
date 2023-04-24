package com.kostya.rtttesttask.linksapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "No such link", value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {}
