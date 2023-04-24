package com.kostya.rtttesttask.linksapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "Link is malformed", value = HttpStatus.BAD_REQUEST)
public class MalformedLinkException extends RuntimeException{}
