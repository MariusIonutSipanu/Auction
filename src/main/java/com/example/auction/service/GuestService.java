package com.example.auction.service;

import com.example.auction.entities.Auction;
import com.example.auction.entities.Guest;
import com.example.auction.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
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
        Optional<Guest> guestOptional = guestRepository.findGuestByFirstNameAndLastName(guest.getFirstName(), guest.getLastName());
        if (guestOptional.isPresent()) { // ADD MORE VALIDATION!!
            throw new IllegalStateException("Guest already exists in table.");
        }
        guestRepository.save(guest);
    }

    public void deleteGuest(Long guestId) {
        boolean exists = guestRepository.existsById(guestId);
        if (!exists) {
            throw new IllegalStateException("Guest with ID " + guestId + " does not exist.");
        }
        guestRepository.deleteById(guestId);
    }

    @Transactional
    public void updateGuest(Long guestId, Double cash) {
        Guest guest = guestRepository.findById(guestId).orElseThrow(() -> new IllegalStateException("Guest with ID " + guestId + " does not exist."));
        if (cash < 0) {
            throw new IllegalStateException("Cash cannot be lower than 0.");
        }
        if (cash != null && (guest.getCash() != cash)) {
            guest.setCash(cash);
        }
    }
}
