package com.example.PrimerParcialDesarollo_MoyanoGonzalo.Service;

import com.example.PrimerParcialDesarollo_MoyanoGonzalo.Entities.Dna;
import com.example.PrimerParcialDesarollo_MoyanoGonzalo.Repository.dnaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class dnaServiceTest {

    @Autowired
    private dnaService servicio;

    @Autowired
    private dnaRepository repository;

    @BeforeEach
    void setUp() {
        // Limpiar la base de datos antes de cada prueba
        repository.deleteAll();
    }

    @Test
    public void testIsMutant() {
        String[] dnaMutant = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
        assertTrue(dnaService.isMutant(dnaMutant));

        String[] dnaNotMutant = {"ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTG"};
        assertFalse(dnaService.isMutant(dnaNotMutant));
    }

    @Test
    public void testAnalizarDna() {
        String[] dnaMutant = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
        assertTrue(servicio.analizarDna(dnaMutant));

        String[] dnaNotMutant = {"ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTG"};
        assertFalse(servicio.analizarDna(dnaNotMutant));
    }
}