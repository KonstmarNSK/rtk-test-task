package com.kostya.rtttesttask.linksapi;


import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
public interface LinkServiceRest {

    @PostMapping(path = "/")
    String saveLink(@RequestParam String longLink);

    @GetMapping(path = "/{shortLink}")
    String getLongLink(@PathVariable String shortLink);
}