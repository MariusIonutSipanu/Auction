package com.example.auction.config;

import com.example.auction.entities.Auction;
import com.example.auction.repository.AuctionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.JANUARY;

@Configuration
public class AuctionConfig {
    private String time = "  20:   20                    ";

    @Bean
    CommandLineRunner auctionCommandLineRunner(AuctionRepository auctionRepository) {
        return args -> {
            Auction firstAuction = new Auction("Timisoara", LocalDate.of(2022, JANUARY, 20), "18:00");
            Auction secondAuction = new Auction("Craiova", LocalDate.of(2022, JANUARY, 21), time.replaceAll("\\s+", ""));

            auctionRepository.saveAll(List.of(firstAuction, secondAuction));
        };
    }
}
//something bad