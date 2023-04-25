package com.kostya.rtttesttask.linkservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("linkservice")
public class ServiceConfig {
    private Integer maxLinkLength;

    public Integer getMaxLinkLength() {
        return maxLinkLength;
    }

    public void setMaxLinkLength(Integer maxLinkLength) {
        this.maxLinkLength = maxLinkLength;
    }
}
