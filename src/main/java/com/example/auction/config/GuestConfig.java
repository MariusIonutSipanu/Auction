package com.example.auction.config;

import com.example.auction.entities.Guest;
import com.example.auction.repository.GuestRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class GuestConfig {

    @Bean
    CommandLineRunner guestCommandLineRunner(
            GuestRepository guestRepository) {
        return args -> {
            Guest marius = new Guest("Marius", "Sipanu", 50000.1231);

            guestRepository.saveAll(List.of(marius));
        };
    }
}