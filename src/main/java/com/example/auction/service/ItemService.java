package com.example.auction.service;
import com.example.auction.entities.Currency;
import com.example.auction.entities.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    public List<Item> getItems() {
        return List.of(new Item(1l, "Gold spoon", 14210, Currency.€));
    }

}
