package com.example.PrimerParcialDesarollo_MoyanoGonzalo.DTO;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class dnaRequestTest {

    @Test
    void testGetDna() {
        // Arrange
        dnaRequest request = new dnaRequest();
        String[] expectedDna = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
        request.setDna(expectedDna);

        // Act
        String[] actualDna = request.getDna();

        // Assert
        assertArrayEquals(expectedDna, actualDna);
    }

    @Test
    void testSetDna() {
        // Arrange
        dnaRequest request = new dnaRequest();
        String[] expectedDna = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};

        // Act
        request.setDna(expectedDna);
        String[] actualDna = request.getDna();

        // Assert
        assertArrayEquals(expectedDna, actualDna);
    }
}