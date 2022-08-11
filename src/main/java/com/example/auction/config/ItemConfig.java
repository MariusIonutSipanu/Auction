package com.example.auction.config;
import com.example.auction.entities.Item;
import com.example.auction.repository.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ItemConfig {

    @Bean
    CommandLineRunner itemCommandLineRunner(
            ItemRepository itemRepository) {

        return args -> {
            Item firstItem = new Item("Silver chair", 3000.50);
            itemRepository.saveAll(List.of(firstItem));
        };
    }

}
