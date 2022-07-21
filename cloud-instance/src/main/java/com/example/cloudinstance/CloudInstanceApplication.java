package com.example.cloudinstance;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class CloudInstanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudInstanceApplication.class, args);
    }

    @GetMapping("/instances/info")
    public String info(@Value("${server.port}") String port) {

        return "instance port : " + port;
    }
}
