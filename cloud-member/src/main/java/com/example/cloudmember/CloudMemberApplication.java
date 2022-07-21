package com.example.cloudmember;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class CloudMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudMemberApplication.class, args);
    }


    @GetMapping("/config")
    public List<String> config(
        @Value("${spring.profiles.active}") String active,
        @Value("${default.product.names}") List<String> values,
        @Value("${default.message}") String message
    ) {
//        List<String> values = new ArrayList<>();
        values.add(active.toUpperCase(Locale.ROOT) +"`s default message: " + message);
        return values;
    }

    @GetMapping("/info")
    public String info(@Value("${server.port}") String port) {

        return "member port : " + port;
    }

    @GetMapping("/auth")
    public String auth(@RequestHeader(value = "token") String token) {
        return "token is " + token;
    }
}
