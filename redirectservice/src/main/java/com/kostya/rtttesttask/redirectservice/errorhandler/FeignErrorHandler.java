package com.kostya.rtttesttask.redirectservice.errorhandler;

import com.kostya.rtttesttask.linksapi.exception.LinkTooLongException;
import com.kostya.rtttesttask.linksapi.exception.NotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

@Component
public class FeignErrorHandler implements ErrorDecoder {

    private final ErrorDecoder errorDecoder = new Default();


    @Override
    public Exception decode(String methodKey, Response response) {
        return switch (response.status()) {
            case 413 -> new LinkTooLongException();
            case 404 -> new NotFoundException();
            default -> errorDecoder.decode(methodKey, response);
        };
    }
}
