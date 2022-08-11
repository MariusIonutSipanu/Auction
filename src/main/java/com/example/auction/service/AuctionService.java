package com.example.auction.service;

import com.example.auction.entities.Auction;
import com.example.auction.entities.Item;
import com.example.auction.repository.AuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void addNewAuction(Auction newAuction) {
        String trimmed = newAuction.getTime().replaceAll("\\s+","");
        newAuction.setTime(trimmed);
        Optional<Auction> auctionOptional = auctionRepository.
                findAuctionByLocationAndTime(newAuction.getLocation(), newAuction.getTime());
        if (auctionOptional.isPresent()) { // ADD MORE VALIDATION!!
            throw new IllegalStateException("Auction at inputted location and time already exists.");
        }
        auctionRepository.save(newAuction);
    }
}
