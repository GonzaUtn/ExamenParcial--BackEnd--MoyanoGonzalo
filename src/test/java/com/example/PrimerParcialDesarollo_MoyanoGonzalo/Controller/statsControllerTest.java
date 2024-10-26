package com.example.PrimerParcialDesarollo_MoyanoGonzalo.Controller;

import com.example.PrimerParcialDesarollo_MoyanoGonzalo.DTO.StatsResponse;
import com.example.PrimerParcialDesarollo_MoyanoGonzalo.Entities.Dna;
import com.example.PrimerParcialDesarollo_MoyanoGonzalo.Repository.dnaRepository;
import com.example.PrimerParcialDesarollo_MoyanoGonzalo.Service.statsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class statsControllerTest {

    @Autowired
    private statsController controller;

    @Autowired
    private statsService servicio;

    @Autowired
    private dnaRepository repository;

    @BeforeEach
    void setUp() {
        // Limpiar la base de datos antes de cada prueba
        repository.deleteAll();
    }

    @Test
    void testGetStats() {
        // Insertar registros de ADN mutantes y humanos
        repository.save(new Dna("ATGCGA,CAGTGC,TTATGT,AGAAGG,CCCCTA,TCACTG", true));
        repository.save(new Dna("ATGCGA,CAGTGC,TTATGT,AGAAGG,CCCCTA,TCACTG", true));
        repository.save(new Dna("ATGCGA,CAGTGC,TTATGT,AGAAGG,CCCCTA,TCACTG", true));
        repository.save(new Dna("ATGCGA,CAGTGC,TTATGT,AGAAGG,CCCCTA,TCACTG", true));
        repository.save(new Dna("ATGCGA,CAGTGC,TTATTT,AGACGG,GCGTCA,TCACTG", false));
        repository.save(new Dna("ATGCGA,CAGTGC,TTATTT,AGACGG,GCGTCA,TCACTG", false));
        repository.save(new Dna("ATGCGA,CAGTGC,TTATTT,AGACGG,GCGTCA,TCACTG", false));
        repository.save(new Dna("ATGCGA,CAGTGC,TTATTT,AGACGG,GCGTCA,TCACTG", false));
        repository.save(new Dna("ATGCGA,CAGTGC,TTATTT,AGACGG,GCGTCA,TCACTG", false));
        repository.save(new Dna("ATGCGA,CAGTGC,TTATTT,AGACGG,GCGTCA,TCACTG", false));

        // Llamar al método getStats
        ResponseEntity<StatsResponse> response = controller.getStats();

        // Verificar los resultados
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(4L, response.getBody().getCantidadMutantes());
        assertEquals(6L, response.getBody().getCantidadHumanos());
        assertEquals(0.6666666666666666, response.getBody().getRatio());
    }

    @Test
    void testGetStatsWithNoHumans() {
        // Insertar registros de ADN mutantes
        repository.save(new Dna("ATGCGA,CAGTGC,TTATGT,AGAAGG,CCCCTA,TCACTG", true));
        repository.save(new Dna("ATGCGA,CAGTGC,TTATGT,AGAAGG,CCCCTA,TCACTG", true));
        repository.save(new Dna("ATGCGA,CAGTGC,TTATGT,AGAAGG,CCCCTA,TCACTG", true));
        repository.save(new Dna("ATGCGA,CAGTGC,TTATGT,AGAAGG,CCCCTA,TCACTG", true));

        // Llamar al método getStats
        ResponseEntity<StatsResponse> response = controller.getStats();

        // Verificar los resultados
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(4L, response.getBody().getCantidadMutantes());
        assertEquals(0L, response.getBody().getCantidadHumanos());
        assertEquals(0.0, response.getBody().getRatio());
    }
}