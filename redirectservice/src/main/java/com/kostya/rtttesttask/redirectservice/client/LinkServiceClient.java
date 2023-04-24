package com.kostya.rtttesttask.redirectservice.client;

import com.kostya.rtttesttask.linksapi.LinkServiceRest;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "link-service")
public interface LinkServiceClient extends LinkServiceRest {}
