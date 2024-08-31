package com.parcial.parcialimplementacion;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParcialImplementacionApplication {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        System.setProperty("CONNECTION_URL", dotenv.get("CONNECTION_URL"));
        System.setProperty("USER", dotenv.get("USER"));
        System.setProperty("PASSWORD", dotenv.get("PASSWORD"));
        SpringApplication.run(ParcialImplementacionApplication.class, args);
    }

}
