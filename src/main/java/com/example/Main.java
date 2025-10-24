package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Spring Boot application.
 * <p>
 * Run this class to start the embedded server and initialize the application context.
 * </p>
 *
 * <p>Profiles are activated via {@code spring.profiles.active} or via the application YAML files.</p>
 *
 * @see org.springframework.boot.SpringApplication
 * @since 1.0
 */
@SpringBootApplication
public class Main {
    /**
     * Application main method.
     *
     * @param args startup arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
