package com.example.auction.service;

import com.example.auction.entities.Guest;
import com.example.auction.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {

    private final GuestRepository guestRepository;

    @Autowired
    public GuestService(GuestRepository guestRepository) {

        this.guestRepository = guestRepository;
    }

    public List<Guest> getGuests() {
        return guestRepository.findAll();
    }
}
