package com.example.auction.service;

import com.example.auction.entities.Item;
import com.example.auction.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    public void addNewItem(Item item) {
        Optional<Item> itemOptional = itemRepository.
                findItemByName(item.getName());
        if (itemOptional.isPresent()) { // ADD MORE VALIDATION!!
            throw new IllegalStateException("Item already exists.");
        }
        itemRepository.save(item);
    }
}
