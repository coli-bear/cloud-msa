package com.example.cloudmember;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class CloudMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudMemberApplication.class, args);
    }


    @GetMapping("/members/config")
    public String config(
        @Value("${spring.profiles.active}") String active,
        @Value("${default.message}") String message
    ) {
//        String active = "TEST";
        return active.toUpperCase(Locale.ROOT) +"`s default message: " + message;
    }

    @GetMapping("/members/info")
    public String info(@Value("${server.port}") String port) {

        return "member port : " + port;
    }
}
