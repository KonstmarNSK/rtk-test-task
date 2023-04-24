package com.kostya.rtttesttask.redirectservice.controller;

import com.kostya.rtttesttask.redirectservice.client.LinkServiceClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;

@Controller
@RequestMapping("/")
public class RedirectController {

    private LinkServiceClient linkServiceClient;

    public RedirectController(LinkServiceClient linkServiceClient) {
        this.linkServiceClient = linkServiceClient;
    }

    @GetMapping(path = "/{shortLink}")
    public ResponseEntity<Void> redirect(@PathVariable String shortLink) {
        String longLink = linkServiceClient.getLongLink(shortLink);

        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(longLink))
                .build();
    }
}
