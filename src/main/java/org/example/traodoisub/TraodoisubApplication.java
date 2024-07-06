package org.example.traodoisub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@EnableScheduling
public class TraodoisubApplication {

    public static void main(String[] args) {
        SpringApplication.run(TraodoisubApplication.class, args);
    }

}
