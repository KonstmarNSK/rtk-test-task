package com.kostya.rtttesttask.tests.utils;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import static com.kostya.rtttesttask.tests.utils.ServiceAdresses.LINKS_URL_PREFIX;
import static com.kostya.rtttesttask.tests.utils.ServiceAdresses.REDIRECT_URL_PREFIX;

public class Requests {
    public static <T> HttpResponse<T> createShortLink(String longLink, HttpResponse.BodyHandler<T> bodyHandler) throws Exception{
        URI uri = URI.create(LINKS_URL_PREFIX + "?longLink=" + URLEncoder.encode(longLink, StandardCharsets.UTF_8));

        HttpRequest req = HttpRequest.newBuilder(uri)
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();

        HttpClient client = HttpClient.newHttpClient();

        return client.send(req, bodyHandler);
    }

    public static <T> HttpResponse<T> getLongLink(String shortLink, HttpResponse.BodyHandler<T> bodyHandler) throws Exception{
        URI uri = URI.create(LINKS_URL_PREFIX + shortLink);

        HttpRequest req = HttpRequest.newBuilder(uri)
                .GET()
                .build();

        HttpClient client = HttpClient.newHttpClient();

        return client.send(req, bodyHandler);
    }

    public static <T> HttpResponse<T> callRedirect(String shortLink, HttpResponse.BodyHandler<T> bodyHandler) throws Exception{
        URI uri = URI.create(REDIRECT_URL_PREFIX + shortLink);

        HttpRequest req = HttpRequest.newBuilder(uri)
                .GET()
                .build();

        HttpClient client = HttpClient.newHttpClient();

        return client.send(req, bodyHandler);
    }
}
