package com.kostya.rtttesttask.redirectservice.controller;

import com.kostya.rtttesttask.redirectservice.client.LinkServiceClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RedirectController {

    private LinkServiceClient linkServiceClient;

    public RedirectController(LinkServiceClient linkServiceClient) {
        this.linkServiceClient = linkServiceClient;
    }

    @GetMapping(path = "/{shortLink}")
    public String redirect(@PathVariable String shortLink) {
        String longLink = linkServiceClient.getLongLink(shortLink);

        //todo: remove
        longLink = "http://" + longLink;

        return "redirect:" + longLink;
    }
}
