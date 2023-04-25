package com.kostya.rtttesttask.tests.utils;

import com.kostya.rtttesttask.tests.LinkServiceTests;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class ServiceAdresses {
    public static final String LINKS_URL_PREFIX;
    public static final String REDIRECT_URL_PREFIX;

    static {
        URL propsUrl = LinkServiceTests.class.getClassLoader().getResource("props.properties");

        if(propsUrl == null) {
            throw new IllegalStateException("No properties with urls. There must be a 'props.properties' file in resources folder");
        }

        Properties props = new Properties();

        try(FileInputStream is = new FileInputStream(propsUrl.getFile())) {
            props.load(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        LINKS_URL_PREFIX = (String) props.get("links_url_prefix");
        REDIRECT_URL_PREFIX = (String) props.get("redirect_url_prefix");

        if(LINKS_URL_PREFIX == null) {
            throw new IllegalArgumentException("links_url_prefix must be set");
        }

        if(REDIRECT_URL_PREFIX == null) {
            throw new IllegalArgumentException("redirect_url_prefix must be set");
        }
    }
}
