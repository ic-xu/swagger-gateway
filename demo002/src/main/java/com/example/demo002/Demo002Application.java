package com.example.demo002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class Demo002Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo002Application.class, args);
    }

}
