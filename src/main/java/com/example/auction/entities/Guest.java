package com.example.auction.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table
@Getter @Setter @NoArgsConstructor @ToString //lombok
public class Guest {
    @Id
    @SequenceGenerator(name = "guest_sequence",
            sequenceName = "guest_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "guest_sequence")
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

