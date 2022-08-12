package com.example.auction;

import com.example.auction.repository.AuctionRepository;
import com.example.auction.repository.GuestRepository;
import com.example.auction.repository.ItemRepository;
import com.example.auction.service.AuctionService;
import com.example.auction.service.GuestService;
import com.example.auction.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class AuctionApplicationTests {

    @Autowired
    private AuctionService auctionService;

    @Autowired
    private GuestService guestService;

    @Autowired
    private ItemService itemService;

    @MockBean
    private AuctionRepository auctionRepository;

    @MockBean
    private GuestRepository guestRepository;

    @MockBean
    private ItemRepository itemRepository;

}
