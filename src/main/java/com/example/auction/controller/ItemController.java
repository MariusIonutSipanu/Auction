package com.example.auction.controller;

import com.example.auction.entities.Auction;
import com.example.auction.entities.Item;
import com.example.auction.repository.AuctionRepository;
import com.example.auction.repository.ItemRepository;
import com.example.auction.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/item")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    AuctionRepository auctionRepository;

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

    @PutMapping(path = "{itemId}")
    public void updateItem(@PathVariable("itemId") Long itemId,
                              @RequestParam(required = false) Double currentBid)
    {
        itemService.updateItem(itemId, currentBid);
    }

    @PutMapping("/{itemId}/addItemToAuction/{auctionId}")
    Item addItemsToAuction(@PathVariable Long itemId,
                           @PathVariable Long auctionId){
        Item item = itemRepository.findById(itemId).get();
        Auction auction = auctionRepository.findById(auctionId).get();
        item.assignAuction(auction);
        return itemRepository.save(item);
    }

}