package com.example.auction.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
public class Auction {
    @Id
    private Long id;
    private String location;
    private LocalDate date;
    private String time;

    public Auction() {
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
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


