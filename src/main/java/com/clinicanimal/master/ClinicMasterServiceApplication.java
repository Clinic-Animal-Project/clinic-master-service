package com.clinicanimal.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ClinicMasterServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClinicMasterServiceApplication.class, args);
    }

}
