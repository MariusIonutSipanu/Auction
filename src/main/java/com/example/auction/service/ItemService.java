package com.example.auction.service;

import com.example.auction.entities.Guest;
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
        Optional<Item> itemOptional = itemRepository.
                findItemByName(item.getName());
        if (itemOptional.isPresent()) { // ADD MORE VALIDATION!!
            throw new IllegalStateException("Item already exists.");
        }
        itemRepository.save(item);
    }

    public void deleteItem(Long itemId) {
        boolean exists = itemRepository.existsById(itemId);
        if (!exists) {
            throw new IllegalStateException
                    ("Item with ID " + itemId + " does not exist.");
        }
        itemRepository.deleteById(itemId);
    }

    @Transactional
    public void updateItem(Long itemId, Double currentBid) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalStateException(
                        "Item with ID " + itemId + " does not exist."));
        if (currentBid < 0) {
            throw new IllegalStateException("Bid cannot be lower than 0.");
        }
        if (currentBid != null && (item.getStartingBid() != currentBid)) {
            item.setStartingBid(currentBid);
        }
    }
}
