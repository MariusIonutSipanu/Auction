package com.example.auction.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table
@Getter @Setter @NoArgsConstructor @ToString //lombok
public class Item {
    @Id
    @SequenceGenerator(name = "item_sequence",
            sequenceName = "item_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "item_sequence")
    private Long id;
    private String name;
    private double startingBid;


    public Item(Long id, String name, double startingBid) {
        this.id = id;
        this.name = name;
        this.startingBid = startingBid;
    }

    public Item(String name, double startingBid) {
        this.name = name;
        this.startingBid = startingBid;
    }

}
