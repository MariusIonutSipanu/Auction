package com.example.auction.entity;

import com.example.auction.entities.Guest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class GuestTest {

    private Guest guest;

    @BeforeEach
    void innit() {
        guest = new Guest();
    }

    @ParameterizedTest
    @CsvSource(value = {"Marius    ", "andrei", "    Andreea"})
    public void firstNameShouldNotBeDifferentFromInput(String firstName) {
        guest.setFirstName(firstName);
        assertThat(guest.getFirstName()).isEqualTo(firstName);
    }

    @ParameterizedTest
    @CsvSource(value = {"Popescu", "            Ionescu", "Dumitrascu   "})
    public void lastNameShouldNotBeDifferentFromInput(String lastName) {
        guest.setLastName(lastName);
        assertThat(guest.getLastName()).isEqualTo(lastName);
    }

    @Test
    public void firstNameShouldNotBeNull() {
        assertThatThrownBy(() -> guest.setFirstName(null)).isInstanceOf(RuntimeException.class).hasMessageContaining("Invalid input");
    }

    @Test
    public void lastNameShouldNotBeNull() {
        assertThatThrownBy(() -> guest.setLastName("")).isInstanceOf(RuntimeException.class).hasMessageContaining("Invalid input");
    }

    @Test
    public void cashShouldBeGreaterThan0() {
        assertThatThrownBy(() -> guest.setCash(0)).isInstanceOf(RuntimeException.class).hasMessageContaining("Invalid input");
    }
}

