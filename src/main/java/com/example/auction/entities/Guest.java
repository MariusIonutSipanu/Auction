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
public class Guest {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private double cash;

    public Guest(Long id, String firstName, String lastName, double cash) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cash = cash;
    }

    public Guest(String firstName, String lastName, double cash) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cash = cash;
    }
}

