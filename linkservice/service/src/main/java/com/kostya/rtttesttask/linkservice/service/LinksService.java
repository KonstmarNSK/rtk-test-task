package com.kostya.rtttesttask.linkservice.service;

import com.kostya.rtttesttask.linkservice.entity.LinksPair;
import com.kostya.rtttesttask.linksapi.exception.LinkTooLongException;
import com.kostya.rtttesttask.linkservice.repo.LinksRepo;
import com.kostya.rtttesttask.linkservice.utils.LinkEncoder;
import com.kostya.rtttesttask.linksapi.exception.LinkRangeOverflowException;
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

    @Transactional
    public String saveLongLink(String longLink) {
        longLink = validateLongLink(longLink);

        // generated link is guaranteed to be unique since it is just a number from sequence in db
        String generatedLink = LinkEncoder.encode(repo.getNextLinkNumber(), 13).orElseThrow(LinkRangeOverflowException::new);
        repo.save(new LinksPair(generatedLink, longLink));

        return generatedLink;
    }


    private static String validateLongLink(String longLink) {

        if (!(longLink.startsWith("https://") || longLink.startsWith("http://"))) {
            longLink = "http://" + longLink;
        }

        if (longLink.length() > 500) {  // fixme: add constant
            throw new LinkTooLongException();
        }

        return longLink;
    }

}
