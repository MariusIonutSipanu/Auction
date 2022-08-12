package com.example.auction.controller;

import com.example.auction.entities.Guest;
import com.example.auction.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/guest")
public class GuestController {

    private final GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService) {

        this.guestService = guestService;
    }

    @GetMapping
    public List<Guest> getGuests() {

        return guestService.getGuests();
    }

    @PostMapping
    public void registerNewGuest(@RequestBody Guest guest) {

        guestService.addNewGuest(guest);
    }

    @DeleteMapping(path = "{guestId}")
    public void deleteGuest(@PathVariable("guestId") Long guestId) {
        guestService.deleteGuest(guestId);
    }

    @PutMapping(path = "{guestId}")
    public void updateGuest(@PathVariable("guestId") Long guestId,
                              @RequestParam(required = false) Double cash)
    {
        guestService.updateGuest(guestId, cash);
    }
}