package com.kostya.rtttesttask.linkservice.controller;

import com.kostya.rtttesttask.linkservice.services.LinksService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class RestEndpoint {

    private LinksService linksService;

    public RestEndpoint(LinksService linksService) {
        this.linksService = linksService;
    }

    @PostMapping(path = "/")
    public String saveLink(@RequestParam String longLink) {
        return linksService.saveLongLink(longLink);
    }

    @GetMapping(path = "/{shortLink}")
    public String getLongLink(@PathVariable String shortLink) {
        return linksService.getLongLink(shortLink).orElse("Nothing");
    }
}
