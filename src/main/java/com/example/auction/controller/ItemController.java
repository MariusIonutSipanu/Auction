package com.example.auction.controller;

import com.example.auction.entities.Currency;
import com.example.auction.entities.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/item")
public class ItemController {

    @GetMapping
    public List<Item> getItems() {
        return List.of(new Item(1L, "Something really expensive I guess", 200000, Currency.RON));

    }
}