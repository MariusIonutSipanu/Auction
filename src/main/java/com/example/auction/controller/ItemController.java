package com.example.auction.controller;

import com.example.auction.entities.Item;
import com.example.auction.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/item")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {

        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> getItems() {
        return itemService.getItems();
    }

    @PostMapping
    public void registerNewItem(@RequestBody Item item){

        itemService.addNewItem(item);
    }

    @DeleteMapping(path = "{itemId}")
        public void deleteItem(@PathVariable("itemId") Long itemId) {
            itemService.deleteItem(itemId);
    }

}