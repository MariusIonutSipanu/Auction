package com.example.auction.entities;

import com.example.auction.Exceptions.InvalidInputException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@ToString //lombok
public class Item {
    @Id
    @SequenceGenerator(name = "item_sequence", sequenceName = "item_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_sequence")
    private Long id;
    private String name;
    private double startingBid;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "auction_id", referencedColumnName = "id")
    private Auction auction;

    public Item(Long id, String name, double startingBid) {
        this.id = id;
        this.name = name;
        this.startingBid = startingBid;
    }

    public Item(String name, double startingBid) {
        this.name = name;
        this.startingBid = startingBid;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new InvalidInputException("Invalid input");
        }
        this.name = name;
    }

    public void setStartingBid(double startingBid) {
        if (startingBid <= 0) {
            throw new InvalidInputException("Invalid input");
        }
        this.startingBid = startingBid;
    }

    public Auction getAuction() {

        return auction;
    }

    public void assignAuction(Auction auction) {

        this.auction = auction;
    }
}
