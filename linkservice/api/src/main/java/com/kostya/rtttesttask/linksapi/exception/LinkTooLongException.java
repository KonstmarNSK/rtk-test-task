package com.kostya.rtttesttask.linksapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "Long link must fit in 500 symbols", value = HttpStatus.PAYLOAD_TOO_LARGE)
public class LinkTooLongException extends RuntimeException{}
