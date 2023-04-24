package com.kostya.rtttesttask.redirectservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class RedirectserviceApplication {

	public static void main(String[] args) {
        SpringApplication.run(RedirectserviceApplication.class, args);
	}

}
