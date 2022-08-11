package com.example.auction.repository;

import com.example.auction.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("SELECT s FROM Item s WHERE s.name = ?1")
    Optional<Item> findItemByName(String name);
}
