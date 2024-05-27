package com.ericsson.owa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"controllers","dto"})
@EntityScan( {"dao", "dto"} )
@EnableJpaRepositories({"dao", "dto"})
public class OperatorWebAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(OperatorWebAppApplication.class, args);
        System.out.println(" The Operator call fault is up and running ");
    }

}
