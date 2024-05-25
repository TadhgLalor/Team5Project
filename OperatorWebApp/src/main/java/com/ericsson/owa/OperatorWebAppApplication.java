package com.ericsson.owa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OperatorWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(OperatorWebAppApplication.class, args);
        System.out.println("OperatorWebAppApplication running...");
    }

}
