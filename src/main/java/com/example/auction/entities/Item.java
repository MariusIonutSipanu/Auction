package com.example.auction.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Getter @Setter @NoArgsConstructor @ToString //lombok
public class Item {
    @Id
    private Long id;
    private String name;
    private double startingBid;
    private Currency currency;


    public Item(Long id, String name, double startingBid, Currency currency) {
        this.id = id;
        this.name = name;
        this.startingBid = startingBid;
        this.currency = currency;
    }

    public Item(String name, double startingBid, Currency currency) {
        this.name = name;
        this.startingBid = startingBid;
        this.currency = currency;
    }

}
