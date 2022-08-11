package com.example.auction.service;

import com.example.auction.entities.Auction;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class AuctionService {

    public List<Auction> getAuctions() {
        return List.of(new Auction(1l, "Calafat",
                LocalDate.of(2022, Month.AUGUST, 23),
                "18:00"));
    }

}
