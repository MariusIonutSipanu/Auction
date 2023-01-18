package com.example.auction.service;

import com.example.auction.Exceptions.IdNotFoundException;
import com.example.auction.Exceptions.InvalidInputException;
import com.example.auction.Exceptions.ObjectAlreadyExistsException;
import com.example.auction.entities.Item;
import com.example.auction.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
        Optional<Item> itemOptional = itemRepository.findItemByName(item.getName());
        if (itemOptional.isPresent()) { // ADD MORE VALIDATION!!
            throw new ObjectAlreadyExistsException("Item already exists.");
        }
        itemRepository.save(item);
    }

    public void deleteItem(Long itemId) {
        boolean exists = itemRepository.existsById(itemId);
        if (!exists) {
            throw new IdNotFoundException("Item with ID " + itemId + " does not exist.");
        }
        itemRepository.deleteById(itemId);
    }

    @Transactional
    public void updateItem(Long itemId, Double currentBid) {
        Item item = itemRepository.findById(itemId).orElseThrow(() -> new IdNotFoundException("Item with ID " + itemId + " does not exist."));
        if (currentBid < 0) {
            throw new InvalidInputException("Bid cannot be lower than 0.");
        }
        if (currentBid != null && (item.getStartingBid() < currentBid)) {
            item.setStartingBid(currentBid);
        } else {
            throw new InvalidInputException("New bid cannot be lower than starting bid.");
        }
    }

    public void addItemToAuction(Long itemId, Long auctionId) {
    }
}
