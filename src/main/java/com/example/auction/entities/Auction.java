package com.example.auction.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@ToString//lombok
public class Auction {
    @Id
    @SequenceGenerator(name = "auction_sequence",
            sequenceName = "auction_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "auction_sequence")
    private Long id;
    private String location;
    private LocalDate date;
    private String time;


    @JsonIgnore
    @OneToMany(mappedBy = "auction")
    private Set<Item> items = new HashSet<>();

    public Auction(Long id,
                   String location,
                   LocalDate date,
                   String time) {
        this.id = id;
        this.location = location;
        this.date = date;
        this.time = time.replaceAll("\\s+", "");

    }

    public Auction(String location, LocalDate date, String time) {
        this.location = location;
        this.date = date;
        this.time = time.replaceAll("\\s+", "");
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setLocation(String location) {
        if (location == null || location.isEmpty()) {
            throw new IllegalStateException("Invalid input");
        }
        this.location = location;
    }

    public void setTime(String time) {
        if (time == null || time.isEmpty()) {
            throw new IllegalStateException("Invalid input");
        }
        this.time = time;
    }

    public void setDate(LocalDate date) {
        if (date == null) {
            throw new IllegalStateException("Invalid input");
        }
        this.date = date;
    }

}


