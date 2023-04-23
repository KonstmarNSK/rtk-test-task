package com.kostya.rtttesttask.linkservice.services;

import com.kostya.rtttesttask.linkservice.entities.LinksPair;
import com.kostya.rtttesttask.linkservice.repos.LinksRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class LinksService {

    private LinksRepo repo;

    public LinksService(LinksRepo repo) {
        this.repo = repo;
    }


    @Transactional(readOnly = true)
    public Optional<String> getLongLink(String shortLink) {
        return repo.findById(shortLink).map(LinksPair::getLongLink);
    }

    // todo: check if that long link is already stored
    @Transactional
    public String saveLongLink(String longLink) {

        // generated link is guaranteed to be unique since it is just a hex number from sequence in db
        String generatedLink = Long.toHexString(repo.getNextLinkNumber());
        repo.save(new LinksPair(generatedLink, longLink));

        return generatedLink;
    }

}
