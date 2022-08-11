package com.example.auction;

import com.example.auction.entities.Auction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController
public class AuctionApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuctionApplication.class, args);
    }

    @GetMapping
    public List<Auction> hello(){
        return List.of(
                new Auction(1L, "Calafat",
                        LocalDate.of(2000, Month.APRIL, 5), "18:00"));

    }

}
