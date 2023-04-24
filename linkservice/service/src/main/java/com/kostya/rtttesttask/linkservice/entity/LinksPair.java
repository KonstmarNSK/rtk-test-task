package com.kostya.rtttesttask.linkservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "LINKS")
public class LinksPair {

    @Id
    @Column(name = "short_link")
    private String shortLink;

    @Column(name = "long_link")
    private String longLink;


    public LinksPair() {}

    public LinksPair(String shortLink, String longLink) {
        this.shortLink = shortLink;
        this.longLink = longLink;
    }

    public String getShortLink() {
        return shortLink;
    }

    public String getLongLink() {
        return longLink;
    }
}
