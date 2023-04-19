package com.tads.jerseymarketapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@RestController
public class JerseyMarketApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(JerseyMarketApiApplication.class, args);
    }

    @GetMapping("/")
    public String index() {
        return "Olá amigo, se você chegou até aqui, significa que você viu o projeto e sou grato por isso!";
    }

}
