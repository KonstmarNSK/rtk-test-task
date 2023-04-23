package com.kostya.rtttesttask.linkservice.repos;

import com.kostya.rtttesttask.linkservice.entities.LinksPair;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LinksRepo extends CrudRepository<LinksPair, String> {

    @Query(nativeQuery = true, value = "Select next_link_num.nextval from dual")
    Long getNextLinkNumber();
}
