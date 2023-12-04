package com.geesun;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.geesun"})
public class SpringbootTokenApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTokenApplication.class, args);
    }

}