package com.example.hirecar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HirecarApplication {


    public static void main(String[] args) {
        SpringApplication.run(HirecarApplication.class, args);

    }

}
