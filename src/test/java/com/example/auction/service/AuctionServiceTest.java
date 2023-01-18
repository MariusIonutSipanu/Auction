package com.example.auction.service;

import com.example.auction.repository.AuctionRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AuctionServiceTest {

    @Autowired
    AuctionService auctionService;

    @Autowired
    AuctionRepository auctionRepository;


    //@Test
    //void locationShouldThrowExceptionIfNull() {
    //    assertThatThrownBy(() -> auction.setLocation(null)).isInstanceOf(RuntimeException.class).hasMessageContaining("Invalid input");
   // }

}
