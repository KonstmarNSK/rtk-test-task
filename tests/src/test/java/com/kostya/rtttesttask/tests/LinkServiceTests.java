package com.kostya.rtttesttask.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import static com.kostya.rtttesttask.tests.utils.Requests.createShortLink;
import static com.kostya.rtttesttask.tests.utils.Requests.getLongLink;


public class LinkServiceTests {

    @Test
    public void checkLinkCreation() throws Exception {
        String result = createShortLink("https://google.com", BodyHandlers.ofString()).body();

        Assertions.assertNotNull(result);
        Assertions.assertFalse(result.isEmpty());

    }

    @Test
    public void checkLinkPersistence() throws Exception {
        String longLink = "https://google.com";
        String shortLink = createShortLink(longLink, BodyHandlers.ofString()).body();
        String savedLongLink = getLongLink(shortLink, BodyHandlers.ofString()).body();

        Assertions.assertEquals(longLink, savedLongLink);
    }

    @Test
    public void checkIfLinkOverwrites() throws Exception {
        String googleLink = "https://google.com";
        String fbLink = "https://fb.com";

        String googleShortLink = createShortLink(googleLink, BodyHandlers.ofString()).body();
        String fbShortLink = createShortLink(fbLink, BodyHandlers.ofString()).body();

        Assertions.assertNotEquals(googleShortLink, fbShortLink);

        String savedGoogleLink = getLongLink(googleShortLink, BodyHandlers.ofString()).body();
        String savedFbLink = getLongLink(fbShortLink, BodyHandlers.ofString()).body();

        Assertions.assertNotEquals(savedFbLink, savedGoogleLink);
    }

    @Test
    public void check404() throws Exception {
        HttpResponse<String> resp = getLongLink("not-existing-link", BodyHandlers.ofString());

        Assertions.assertEquals(404, resp.statusCode());
    }
}
