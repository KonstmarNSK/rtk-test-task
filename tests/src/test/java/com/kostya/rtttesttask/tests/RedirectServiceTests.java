package com.kostya.rtttesttask.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.http.HttpResponse;
import java.util.Optional;

import static com.kostya.rtttesttask.tests.utils.Requests.callRedirect;
import static com.kostya.rtttesttask.tests.utils.Requests.createShortLink;


public class RedirectServiceTests {

    @Test
    public void checkRedirectCreation() throws Exception {
        String longLink = "https://google.com";
        String shortLink = createShortLink(longLink, HttpResponse.BodyHandlers.ofString()).body();

        HttpResponse<String> response = callRedirect(shortLink, HttpResponse.BodyHandlers.ofString());

        Optional<String> header = response.headers().firstValue("Location");
        Assertions.assertTrue(header.isPresent());

        String location = header.get();

        Assertions.assertEquals(response.statusCode(), 301);
        Assertions.assertEquals(location, longLink);
    }

    @Test
    public void check404() throws Exception {
        HttpResponse<String> response = callRedirect("not-existent", HttpResponse.BodyHandlers.ofString());

        Assertions.assertEquals(404, response.statusCode());
    }
}
