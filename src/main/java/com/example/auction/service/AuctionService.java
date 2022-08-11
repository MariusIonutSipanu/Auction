package com.example.auction.service;

import com.example.auction.entities.Auction;
import com.example.auction.repository.AuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionService {

    private final AuctionRepository auctionRepository;

    @Autowired
    public AuctionService(AuctionRepository auctionRepository) {

        this.auctionRepository = auctionRepository;
    }

    public List<Auction> getAuctions() {
        return auctionRepository.findAll();
    }

}
