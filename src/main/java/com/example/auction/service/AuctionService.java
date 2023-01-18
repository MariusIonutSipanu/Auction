package com.example.auction.service;

import com.example.auction.Exceptions.IdNotFoundException;
import com.example.auction.entities.Auction;
import com.example.auction.entities.Item;
import com.example.auction.repository.AuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
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
        String trimmed = newAuction.getTime().replaceAll("\\s+", "");
        newAuction.setTime(trimmed);
        Optional<Auction> auctionOptional = auctionRepository.findAuctionByLocationAndTime(newAuction.getLocation(), newAuction.getTime());
        if (auctionOptional.isPresent()) { // ADD MORE VALIDATION!!
            throw new IllegalStateException("Auction at inputted location and time already exists.");
        }
        auctionRepository.save(newAuction);
    }

    public void deleteAuction(Long auctionId) {
        boolean exists = auctionRepository.existsById(auctionId);
        if (!exists) {
            throw new IdNotFoundException("Auction with the ID " + auctionId + " does not exist.");
        }
        auctionRepository.deleteById(auctionId);
    }

    @Transactional
    public void updateAuction(Long auctionId, LocalDate date, String time) {
        Auction auction = auctionRepository.findById(auctionId).orElseThrow(() -> new IdNotFoundException("Auction with the  ID " + auctionId + " does not exist."));
        if (date != null && !Objects.equals(auction.getDate(), date)) {
            auction.setDate(date);
        }

        if (time != null && time.length() > 0 && !Objects.equals(auction.getTime(), time)) {
            auction.setTime(time);
        }
    }
}
