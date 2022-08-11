package com.example.auction.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Auction {
    @Id
    private Long id;
    private String location;
    private LocalDate date;
    private String time;

    public Auction(Long id,
                   String location,
                   LocalDate date,
                   String time) {
        this.id = id;
        this.location = location;
        this.date = date;
        this.time = time;
    }

    public Auction(String location, LocalDate date, String time) {
        this.location = location;
        this.date = date;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Auction{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", date=" + date +
                ", time='" + time + '\'' +
                '}';
    }
}


