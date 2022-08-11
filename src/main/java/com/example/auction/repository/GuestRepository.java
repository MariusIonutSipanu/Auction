package com.example.auction.repository;

import com.example.auction.entities.Auction;
import com.example.auction.entities.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {

    Optional<Guest> findGuestByFirstNameAndLastName(String firstName, String lastName);
}
