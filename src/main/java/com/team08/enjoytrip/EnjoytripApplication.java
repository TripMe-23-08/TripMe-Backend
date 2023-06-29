package com.team08.enjoytrip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class EnjoytripApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnjoytripApplication.class, args);
    }

}
