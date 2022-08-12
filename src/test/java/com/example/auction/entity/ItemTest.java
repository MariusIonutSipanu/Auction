package com.example.auction.entity;
import com.example.auction.entities.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ItemTest {
    Item item;

    @BeforeEach
    void init() {
        item = new Item();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "gold  ",
            "   gold"
    })
    void nameShouldNotBeDifferentFromInput(String name) {
        item.setName(name);
        assertThat(item.getName()).isEqualTo(name);
    }

    @Test
    void nameShouldThrowExceptionIfNull() {
        assertThatThrownBy(() -> item.setName(null))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Invalid input");
    }

    @ParameterizedTest
    @CsvSource(value = { "102.2", "201.5", "201.5321"
    })
    void startingBigShouldNotBeDifferentFromInput(String bid) {
        item.setStartingBid(Double.valueOf(bid));
        assertThat(item.getStartingBid() == Double.valueOf(bid));
    }

    @Test
    void startingBidShouldThrowExceptionIfSmallerEqualTo0() {
        assertThatThrownBy(() -> item.setStartingBid(0))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Invalid input");
    }


}