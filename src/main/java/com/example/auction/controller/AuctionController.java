package com.example.auction.controller;

import com.example.auction.entities.Auction;
import com.example.auction.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/auction")
public class AuctionController {

    private final AuctionService auctionService;

    @Autowired
    public AuctionController(AuctionService auctionService) {
        this.auctionService = auctionService;
    }

    //print
    @GetMapping
    public List<Auction> getAuctions() {

        return auctionService.getAuctions();
    }

    //add
    @PostMapping
    public void registerNewAuction(@RequestBody Auction auction) {

        auctionService.addNewAuction(auction);
    }

    //delete
    @DeleteMapping(path = "{auctionId}")
    public void deleteAuction(@PathVariable("auctionId") Long auctionId) {
        auctionService.deleteAuction(auctionId);
    }

    //update
    @PutMapping(path = "{auctionId}")
    public void updateAuction(@PathVariable("auctionId") Long auctionId, @RequestParam(required = false) String date, @RequestParam(required = false) String time) {
        LocalDate localDate = LocalDate.parse(date);
        auctionService.updateAuction(auctionId, localDate, time);
    }
}
