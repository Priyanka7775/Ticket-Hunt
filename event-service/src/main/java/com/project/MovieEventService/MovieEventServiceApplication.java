package com.project.MovieEventService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableFeignClients
@EnableSwagger2
@EnableEurekaClient
public class MovieEventServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieEventServiceApplication.class, args);
    }

}
