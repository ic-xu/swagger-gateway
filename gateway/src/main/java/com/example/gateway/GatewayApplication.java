package com.example.gateway;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.reactive.config.EnableWebFlux;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableDiscoveryClient
@EnableWebFlux
@EnableOpenApi
@EnableKnife4j
public class GatewayApplication {

    // 代码写尽天下事
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

}
