package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.example", "Message", "Bot", "template"})
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

