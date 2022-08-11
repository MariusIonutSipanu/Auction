package com.example.auction.service;

import com.example.auction.entities.Guest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {

    public List<Guest> getGuests() {
        return List.of(new Guest(1l, "Marius", "Sipanu", 30000));
    }
}
