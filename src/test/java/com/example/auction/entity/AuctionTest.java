package com.example.auction.entity;

import com.example.auction.entities.Auction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class AuctionTest {
    Auction auction;

    @BeforeEach
    void init() {
        auction = new Auction();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "location  ",
            "   location"
    })
    void locationShouldNotBeDifferentFromInput(String location) {
        auction.setLocation(location);
        assertThat(auction.getLocation()).isEqualTo(location);
    }

    @Test
    void locationShouldThrowExceptionIfNull() {
        assertThatThrownBy(() -> auction.setLocation(null))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Invalid input");
    }

    @ParameterizedTest
    @CsvSource(value = {
            "18:00",
            "18:00    ",
            "   18:00"
    })
    void timeShouldNotBeDifferentFromInput(String time) {
        auction.setTime(time);
        assertThat(auction.getTime()).isEqualTo(time);
    }

    @Test
    void timeShouldThrowExceptionIfNull() {
        assertThatThrownBy(() -> auction.setTime(null))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Invalid input");
    }

    @Test
    void dateShouldNotBeDifferentFromInput() {
        auction.setDate(LocalDate.of(2010, Month.JANUARY, 10));
        assertThat(auction.getDate()).isEqualTo(LocalDate.of(2010,
                Month.JANUARY, 10));
    }

    @Test
    void dateShouldThrowExceptionIfNull() {
        assertThatThrownBy(() -> auction.setDate(null))
                .hasMessageContaining("Invalid input");
    }
}
