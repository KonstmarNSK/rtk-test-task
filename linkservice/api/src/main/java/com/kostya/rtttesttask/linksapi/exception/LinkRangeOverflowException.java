package com.kostya.rtttesttask.linksapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        reason = """
            Generated short link is too long (maybe there are too many links generated already?). 
            Consider increasing max short link length in configs
        """
        , value = HttpStatus.INTERNAL_SERVER_ERROR)
public class LinkRangeOverflowException extends RuntimeException {
}
