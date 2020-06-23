package com.kira.microdienst.bezahlungservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BezahlungServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BezahlungServiceApplication.class, args);
    }

}
