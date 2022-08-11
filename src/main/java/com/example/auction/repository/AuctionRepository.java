package com.example.auction.repository;

import com.example.auction.entities.Auction;
import com.example.auction.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuctionRepository extends JpaRepository<Auction, Long> {

   // @Query("SELECT s FROM Auction s WHERE s.location = ?1")
    Optional<Auction> findAuctionByLocationAndTime(String location, String time);
}
