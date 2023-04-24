package com.kostya.rtttesttask.linkservice.controller;

import com.kostya.rtttesttask.linksapi.LinkServiceRest;
import com.kostya.rtttesttask.linkservice.service.LinksService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class RestEndpoint implements LinkServiceRest {

    private LinksService linksService;

    public RestEndpoint(LinksService linksService) {
        this.linksService = linksService;
    }

    public String saveLink(String longLink) {
        return linksService.saveLongLink(longLink);
    }

    public String getLongLink(String shortLink) {
        return linksService.getLongLink(shortLink).orElse("Nothing");
    }
}
