package com.example.auction.service;

import com.example.auction.entities.Auction;
import com.example.auction.entities.Guest;
import com.example.auction.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void addNewGuest(Guest guest) {
        Optional<Guest> guestOptional = guestRepository.
                findGuestByFirstNameAndLastName(guest.getFirstName(), guest.getLastName());
        if (guestOptional.isPresent()) { // ADD MORE VALIDATION!!
            throw new IllegalStateException("Guest already exists in table.");
        }
        guestRepository.save(guest);
    }
}
