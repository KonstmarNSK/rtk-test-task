package com.kostya.rtttesttask.linkservice.repo;

import com.kostya.rtttesttask.linkservice.entity.LinksPair;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LinksRepo extends CrudRepository<LinksPair, String> {

    @Query(nativeQuery = true, value = "Select next_link_num.nextval from dual")
    Long getNextLinkNumber();
}
